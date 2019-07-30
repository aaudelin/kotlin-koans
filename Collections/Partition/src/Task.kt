// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = this.customers.filter {
    val (ordered, unordered) = it.orders.partition { it.isDelivered }
    ordered.size < unordered.size
}.toHashSet()
