class PropertyExample() {
    var counter = 0
    var propertyWithCounter: Int? = null
        set(value) {
            counter+=1
            field = value
        }
}