package easy

fun classPhotos(redShirtHeights: MutableList<Int>, blueShirtHeights: MutableList<Int>): Boolean {
    redShirtHeights.sort()
    blueShirtHeights.sort()

    if(redShirtHeights[0] < blueShirtHeights[0]){
        for (i in 1 until redShirtHeights.size){
            if(redShirtHeights[i] > blueShirtHeights[i]){
                return false
            }
        }
    }else if(redShirtHeights[0] > blueShirtHeights[0]) {
        for (i in 1 until redShirtHeights.size){
            if(redShirtHeights[i] < blueShirtHeights[i]){
                return false
            }
        }
    } else {
        return false
    }

    return true
}