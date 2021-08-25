package easy

fun nonConstructibleChange(coins: MutableList<Int>): Int {
    var change = 0
    coins.sort()

    for (coin in coins){
        if(change + 1 < coin) return change + 1
        change += coin
    }

    return change + 1
}