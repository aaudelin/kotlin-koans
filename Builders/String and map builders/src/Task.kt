import java.util.HashMap

fun <T, V> buildMap(build: MutableMap<T, V>.() -> Unit): MutableMap<T, V> {
    val map = mutableMapOf<T, V>()
    map.build()
    return map
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
