import java.util.*

inline fun <T> Collection<out T>.partitionTo(collectionOK: MutableCollection<T>,
                                  collectionKO: MutableCollection<Any?>,
                                  function: (T) -> Boolean): Pair<MutableCollection<T>, MutableCollection<Any?>> {
    for (element in this) {
        if (element is T && function(element)) {
            collectionOK.add(element)
        } else {
            collectionKO.add(element)
        }
    }
    return Pair(collectionOK, collectionKO)

};

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e").
            partitionTo(ArrayList<String>(), ArrayList()) { s -> !s.contains(" ") }
    words == listOf("a", "c")
    lines == listOf("a b", "d e")
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}').
            partitionTo(HashSet<Char>(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    letters == setOf('a', 'r')
    other == setOf('%', '}')
}
