package easy


fun sortedSquaredArray(sortedArray: List<Int>): List<Int> {
    val negativeValuesStack = mutableListOf<Int>()
    var index = 0;
    val sortedSquaredList = mutableListOf<Int>()

    if (sortedArray.size == 1) {
        return listOf(sortedArray[0] * sortedArray[0])
    }

    while (index < sortedArray.size && sortedArray[index] < 0) {
        negativeValuesStack.add(sortedArray[index] * sortedArray[index])
        index++
    }

    if (index == sortedArray.lastIndex || index == sortedArray.size) {
        return negativeValuesStack.reversed()
    }

    var currentValueSquare: Int

    while (index < sortedArray.size) {
        currentValueSquare = sortedArray[index] * sortedArray[index]
        while (negativeValuesStack.isNotEmpty() && negativeValuesStack.last() <= currentValueSquare) {
            sortedSquaredList.add(negativeValuesStack.removeLast())
        }
        sortedSquaredList.add(currentValueSquare)

        index++
    }
    while (negativeValuesStack.isNotEmpty()) {
        sortedSquaredList.add(negativeValuesStack.removeAt(negativeValuesStack.lastIndex))
    }

    return sortedSquaredList
}
//
//    fun get1(sortedArray: List<Int>): List<Int> {
//        val sortedSquareList = mutableListOf<Int>()
//        var lowerIndex = 0
//        var higherIndex = sortedArray.lastIndex
//
//        repeat(sortedArray.size){
//            if(sortedArray[lowerIndex] < sortedArray[h])
//        }
//
//        return sortedSquareList;
//    }