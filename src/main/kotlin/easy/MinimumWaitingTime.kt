package easy

fun minimumWaitingTime(queries: MutableList<Int>): Int {
    var result = 0
    var previousSum = 0

    queries.sort()

    for( i in 1 until queries.size) {
        previousSum += queries[i - 1]
        result += previousSum
    }

    return result
}