package medium

import kotlin.math.abs

fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    var smallestDifference = Int.MAX_VALUE
    var result = listOf<Int>()

    arrayOne.sort()
    arrayTwo.sort()

    var arrayOneIndex = arrayOne.size - 1
    var arrayTwoIndex = arrayTwo.size - 1
    var currentDifference: Int

    while (arrayOneIndex > 0 && arrayTwoIndex > 0) {
        currentDifference = abs(arrayOne[arrayOneIndex] - arrayTwo[arrayTwoIndex])

        if(currentDifference <= smallestDifference) {
            smallestDifference = currentDifference
            result = listOf(arrayOne[arrayOneIndex], arrayTwo[arrayTwoIndex])
            arrayTwoIndex--
        }else {
            arrayOneIndex--
        }
    }

    return result
}