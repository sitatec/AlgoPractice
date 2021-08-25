package easy

fun binarySearch(array: List<Int>, target: Int): Int {
    if(array[0] == target) return  0
    if(array[array.size - 1] == target) return array.size - 1
    return binarySearch(array, target, 0, array.size -1)
}

fun binarySearch(array: List<Int>, target: Int, startIndex: Int, endIndex: Int): Int {

    val halfIndex = (endIndex + startIndex) / 2
    if(halfIndex == startIndex){
        return -1
    }

    return when {
        array[halfIndex] > target -> {
            binarySearch(array, target, startIndex, halfIndex)
        }
        array[halfIndex] < target -> {
            binarySearch(array, target, halfIndex, endIndex)
        }
        else -> {
            halfIndex
        }
    }
}

// [1, 3, 5, 6, 7, 8]