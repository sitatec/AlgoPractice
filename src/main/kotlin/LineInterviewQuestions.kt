import java.util.*

// ----------------------- TASK 3 ------------------------- //

fun formedParentheses(n: Int): Array<String> {
    val result = mutableListOf<String>()
    findCombinations("", result, n)
    return result.toTypedArray()
}

fun findCombinations(parenthese: String, result: MutableList<String>, open: Int, close: Int = open) {
    if (close == 0) {
        result.add(parenthese)
        return
    }
    if (open > 0) {
        findCombinations("$parenthese(", result, open - 1, close)
    }
    if (open < close) {
        findCombinations("$parenthese)", result, open, close - 1)
    }
}

// ----------------------- TASK 4 ------------------------- //

fun getRunningProcessAt(time: Int, logs: Array<String>): String {
    val runningProcessesAtTheGivenTime = mutableListOf<String>()
    var currentProcess: List<String>

    for (i in 0..logs.size) {
        currentProcess = logs[i].split(" ")

        if (currentProcess[0].toInt() > time) {
            break
        }

        if (currentProcess.last() == "running") {
            runningProcessesAtTheGivenTime.add(currentProcess[1])
        } else {
            runningProcessesAtTheGivenTime.remove(currentProcess[1])
        }
    }

    return if (runningProcessesAtTheGivenTime.size == 1) {
        runningProcessesAtTheGivenTime.first()
    } else {
        "-1"
    }
}

fun printGetRunningProcessesAt() {
    println(
        getRunningProcessAt(
            15,
            arrayOf(
                "0 A created",
                "1 B created",
                "10 A running",
                "12 B waiting",
                "13 B running",
                "14 A waiting",
                "17 B terminated",
                "18 A terminated"
            )
        )
    )
}

// -------------------------- TASK 5 ------------------------- //

class HomeMadeMap<K, V>() {

    var size: Int = 0
    private var mapContent = List<LinkedList<Pair<K, V>>>(0) { LinkedList() }
    private var accessHistory = mutableListOf<K>()

    fun add(key: K, value: V) {
        resizeIfNeeded()
        mapContent[getIndexForKey(key)].add(key to value)
        accessHistory.add(key)
    }

    private fun resizeIfNeeded() {
        if (size == mapContent.size) {
            doubleContentSize()
        } else if ((mapContent.size / 2) >= size) {
            divideContentSize()
        }
    }

    private fun doubleContentSize() {
        mapContent = if (mapContent.isEmpty()) {
            List(2) { LinkedList() }
        } else {
            val newContent = List(mapContent.size * 2) { LinkedList<Pair<K, V>>() }

            mapContent.forEach { linkedList ->
                linkedList.forEach { keyValuePair ->
                    newContent[getIndexForKey(keyValuePair.first)].add(keyValuePair)
                }
            }
            newContent
        }
    }

    private fun divideContentSize() {
        val newContent = List(mapContent.size / 2) { LinkedList<Pair<K, V>>() }

        mapContent.forEach { linkedList ->
            linkedList.forEach { keyValuePair ->
                newContent[getIndexForKey(keyValuePair.first)].add(keyValuePair)
            }
        }

        mapContent = newContent
    }

    private fun getIndexForKey(key: K): Int {
        return mapContent.size % key.hashCode()
    }

    fun get(key: K): Any {
        return try {
            mapContent[getIndexForKey(key)].first { it.first == key }
            accessHistory.add(key)
        } catch (e: Exception){
            "-1"
        }
    }

    fun remove(key: K): Any {
        var removedValue: V? = null
       return try {
           mapContent[getIndexForKey(key)].removeIf {
               if(it.first == key){
                   removedValue = it.second
                   true
               }else{
                   false
               }
           }
           accessHistory.removeAll { it == key }
       } catch (e: Exception){
         removedValue ?: "-1"
       }
    }

    fun evict() {
        if(accessHistory.isNotEmpty()){
            remove(accessHistory.removeLast())
        }
    }

    fun exit() {

    }
}
