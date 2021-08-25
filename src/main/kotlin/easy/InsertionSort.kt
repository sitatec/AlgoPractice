package easy

fun insertionSort(array: MutableList<Int>): List<Int> {
    var temp: Int
    var sortedItemCount = 0

    for (i in 1 until array.size){
        for (j in sortedItemCount downTo 0){
            if(array[j + 1] < array[j]){
                temp = array[j + 1]
                array[j + 1] = array[j]
                array[j] = temp
            }
        }
        sortedItemCount += 1
    }

    return array
}

// [8, 5, 2, 9, 5, 6, 3]
// [5, 2, 8]