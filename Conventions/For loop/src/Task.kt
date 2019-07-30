class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    var currentDay: MyDate = start
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            override fun next(): MyDate {
                val nextDay = currentDay.copy()
                currentDay = currentDay.nextDay()
                return nextDay
            }

            override fun hasNext(): Boolean {
                return currentDay <= end
            }

        }
    }

}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}
