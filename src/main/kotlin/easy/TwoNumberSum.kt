package easy

fun TwoNumberSum(nums: IntArray, target: Int): IntArray {

    val sortedNums = nums.sorted()
    var higherIndex = nums.lastIndex
    var lowerIndex = 0
    var currentSum: Int

    var lowerValue: Int
    var higherValue: Int

    repeat(nums.size) {
        lowerValue = sortedNums[lowerIndex]
        higherValue = sortedNums[higherIndex]
        currentSum = lowerValue + higherValue

        when {
            currentSum < target -> lowerIndex++
            currentSum > target -> higherIndex--
            else -> {
                if (higherValue == lowerValue) {
                    var indexOfTheLowerValueInTheUnsortedList = nums.indexOf(lowerValue)
                    for ((index, number) in nums.withIndex()) {
                        if (number == lowerValue && index != indexOfTheLowerValueInTheUnsortedList) {
                            return intArrayOf(indexOfTheLowerValueInTheUnsortedList, index)
                        }
                    }
                }
                return intArrayOf(nums.indexOf(lowerValue), nums.indexOf(higherValue))
            }
        }
    }
    return intArrayOf(-1, -1)
}