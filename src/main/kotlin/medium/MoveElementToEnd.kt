package medium

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    // Write your code here.
    array.sort()
    var rightIndex = array.size - 1
    var leftIndex = rightIndex

    while(leftIndex >= 0) {
        if(array[leftIndex] == toMove){
            while(rightIndex >= 0 && leftIndex >= 0 && array[leftIndex] == toMove) {
                array[leftIndex] = array[rightIndex]
                array[rightIndex] = toMove
                rightIndex--
                leftIndex--
            }
            break
        }
        leftIndex--
    }
    return array
}