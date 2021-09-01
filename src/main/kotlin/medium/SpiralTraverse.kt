package medium

fun spiralTraverse(array: List<List<Int>>): List<Int> {
    if(array.size == 0) return listOf<Int>()

    var result = mutableListOf<Int>()

    var xLeftIndex = 0
    var xRightIndex = array[0].size - 1
    var yTopIndex = 0
    var yBottomIndex = array.size - 1

    while(xRightIndex >= xLeftIndex && yBottomIndex >= yTopIndex){
        for(i in xLeftIndex..xRightIndex){
            result.add(array[yTopIndex][i])
        }

        for(i in yTopIndex+1..yBottomIndex){
            result.add(array[i][xRightIndex])
        }

        if(xRightIndex == xLeftIndex || yBottomIndex == yTopIndex) break

        for(i in xRightIndex-1 downTo xLeftIndex) {
            result.add(array[yBottomIndex][i])
        }

        for(i in yBottomIndex-1 downTo yTopIndex+1) {
            result.add(array[i][xLeftIndex])
        }

        xLeftIndex++
        xRightIndex--
        yTopIndex++
        yBottomIndex--
    }

    return result
}