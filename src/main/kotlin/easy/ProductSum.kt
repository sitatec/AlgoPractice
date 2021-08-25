package easy

fun productSum(array: List<*>, depth: Int = 1): Int {
    var sum = 0

    array.forEach {
        if (it is List<*>){
            sum += productSum(it, depth + 1)
        }else if(it is Int) {
            sum += it
        }
    }

    return sum * depth
}
