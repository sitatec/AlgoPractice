// --------------------- MEMORIZATION --------------------- //
fun howSum(target: Int, numbers: List<Int>, memory: MutableList<Int> = mutableListOf()): MutableList<Int>? {
    return when {
        memory.contains(target) -> null
        target == 0 -> mutableListOf()
        target < 0 -> null
        else -> {
            for (number in numbers) {
                val currentTarget = target - number
                val result = howSum(currentTarget, numbers, memory)
                if (result != null) {
                    return result.apply { add(number) }
                }
            }
            memory.add(target)
            null
        }
    }
}

fun printHowSumOutputs() {
    println(howSum(7, listOf(2, 3))) // [3, 2, 2]
    println(howSum(7, listOf(5, 3, 4, 7))) // // [4, 3]
    println(howSum(7, listOf(2, 4))) // null
    println(howSum(8, listOf(2, 3, 5))) // [2, 2, 2, 2]
    println(howSum(300, listOf(7, 14))) // null
}


fun canConstruct(target: String, wordBank: List<String>, memory: MutableList<String> = mutableListOf()): Boolean {
    if (memory.contains(target)) return false
    if (target.isEmpty()) return true

    for (word in wordBank) {
        val newTarget = target.removePrefix(word)
        if (newTarget != target) {
            if (canConstruct(newTarget, wordBank, memory)) {
                return true
            }
        }
    }
    memory.add(target)
    return false
}

fun printCanConstructOutputs() {
    println(canConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))) // true
    println(canConstruct("skateboard", listOf("bo", "rd", "at", "t", "ska", "sk", "boar"))) // false
    println(canConstruct("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))) // true
    println(
        canConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")
        )
    ) // false
}

fun countConstruct(target: String, wordBank: List<String>, memory: MutableMap<String, Int> = mutableMapOf()): Int {
    if (target.isEmpty()) return 1
    if (memory.containsKey(target)) return memory[target]!!
    var count = 0

    for(word in wordBank) {
        val prefix = target.removePrefix(word)
        if(prefix != target) {
            count += countConstruct(prefix, wordBank, memory)
        }
    }
    memory[target] = count
    return count
}

fun printCountConstructOutputs() {
    println(countConstruct("purple", listOf("purp", "p", "ur", "le", "purpl"))) // 2
    println(countConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))) // 1
    println(countConstruct("skateboard", listOf("bo", "rd", "at", "t", "ska", "sk", "boar"))) // 0
    println(countConstruct("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))) // 4
    println(
        countConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")
        )
    ) // 0
}

fun allConstruct(target: String, wordBank: List<String>): MutableList<MutableList<String>> {
    if(target.isEmpty()) return mutableListOf(mutableListOf())
    val combinations = mutableListOf<MutableList<String>>()

    for (word in wordBank) {
        val currentWordPrefix = target.removePrefix(word)
        if(currentWordPrefix != target) {
            val result = allConstruct(currentWordPrefix, wordBank).onEach { it.add(0, word) }
            combinations.addAll(result)
        }
    }

    return combinations
}


fun printAllConstructOutputs() {
    print2DArray(allConstruct("purple", listOf("purp", "p", "ur", "le", "purpl"))) // 2
    print2DArray(allConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd", "ef", "c"))) // 1
    print2DArray(allConstruct("skateboard", listOf("bo", "rd", "at", "t", "ska", "sk", "boar"))) // 0
    print2DArray(allConstruct("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))) // 4
    print2DArray(
        allConstruct(
            "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee")
        )
    ) // 0
}

private fun print2DArray(array: List<List<Any>>) {
    if(array.isEmpty()) {
        println("[]\n")
        return
    }
    var string = "[\n"
    array.forEach{string = "$string $it\n"}
    println("$string]\n")
}

// ----------------------------- TABULATION ----------------------------- //

fun fibonacciTab(n: Int): Long {
    val fibsArray = Array<Long>(n + 1) {0}
    fibsArray[1] = 1
    var i = 0

    for(currentIndex in 2..n) {
        i += 1
        println(i)
        fibsArray[currentIndex] = fibsArray[currentIndex - 1] + fibsArray[currentIndex -2]
    }

    return fibsArray[n]
}

fun printFibonacciTab() {
    println(fibonacciTab(6)) // 8
    println(fibonacciTab(7)) // 13
    println(fibonacciTab(8)) // 21
    println(fibonacciTab(50)) // 12586269025
}


fun fibonacciTabOptimalSpace(n: Int): Long {
    var currentFib: Long = 1
    var secondFib: Long = 1
    var i = 0

    repeat((n / 2)){
        i += 1
        println(i)
        currentFib += secondFib
        secondFib += currentFib
    }
    return if(n % 2 == 0) secondFib - currentFib else currentFib
}
fun printFibonacciTabOptimalSpace() {
    println(fibonacciTabOptimalSpace(3)) // 2
    println(fibonacciTabOptimalSpace(6)) // 8
    println(fibonacciTabOptimalSpace(7)) // 13
    println(fibonacciTabOptimalSpace(5)) // 5
    println(fibonacciTabOptimalSpace(15)) // 610
    println(fibonacciTabOptimalSpace(19)) // 4181
    println(fibonacciTabOptimalSpace(8)) // 21
    println(fibonacciTabOptimalSpace(50)) // 12586269025
}
