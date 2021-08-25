package easy

fun ValidateSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    if (array.size < sequence.size) return false
    var matchesCount = 0
    var lastMatchingIndexInArray = -1

    for (currentNumberInSequence in sequence) {

        while (++lastMatchingIndexInArray < array.size) {
            if (currentNumberInSequence == array[lastMatchingIndexInArray]) {
                matchesCount++
                break;
            }
        }
    }

    return matchesCount == sequence.size

}