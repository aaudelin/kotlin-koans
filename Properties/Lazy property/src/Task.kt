class LazyProperty(val initializer: () -> Int) {
    var count: Int? = null
    val lazy: Int
        get() {
            if (count == null) {
                count = initializer()
            }
            return count!!
        }
}
