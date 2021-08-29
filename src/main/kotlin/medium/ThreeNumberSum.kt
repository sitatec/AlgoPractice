package medium

fun threeNumberSumOptimal(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    // Write your code here
    return listOf<List<Int>>()
}



fun threeNumberSumBrute(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    var tripletFound = false
    var currentNumber: Int
    val result = mutableListOf<List<Int>>()

    var firstNumber: Int
    var secondNumber: Int
    var thirdNumber: Int

    array.sort()

    for(i in 0 until array.size){
        for(j in i + 1 until array.size){
            for (k in j + 1 until array.size) {
                firstNumber = array[i]
                secondNumber = array[j]
                thirdNumber = array[k]

                currentNumber = firstNumber + secondNumber + thirdNumber
                if(currentNumber == targetSum) {
                    val numbers = listOf(firstNumber, secondNumber, thirdNumber)
                    result.add(numbers)
                }
            }
        }
    }

    return result
}

