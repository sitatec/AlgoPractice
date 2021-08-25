package easy

fun bubbleSort(array: MutableList<Int>): List<Int> {
    var temp = 0
    var sorted = false
    var sortedItemsSize = 0

    while(!sorted){
        sorted = true
        for(i in 0 until array.size - 1 - sortedItemsSize) {
            if(array[i] > array[i + 1]){
                sorted = false
                temp = array[i]
                array[i] = array[i + 1]
                array[i + 1] = temp
            }
        }
        sortedItemsSize += 1
    }

    return array
}