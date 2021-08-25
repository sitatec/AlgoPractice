package easy

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun branchSums(root: BinaryTree): List<Int> {
    // Write your code here.
    var currentNode = root
    var currentSum = currentNode.value
    while (currentNode.left == null) {
        if(currentNode.right != null) {
            currentNode = currentNode.right!!
            currentSum += currentNode.value
        }else {
            return listOf(currentSum)
        }
    }

    return getBranchSum(currentNode, currentSum = currentSum)
}

private fun getBranchSum(
    branch: BinaryTree,
    result: MutableList<Int> = mutableListOf(),
    sumsStack: MutableList<Pair<BinaryTree, Int>> = mutableListOf(),
    currentSum: Int = branch.value
): List<Int> {
    var currentNode = branch
    var currentSumIntern = currentSum

    while (true) {
        if (currentNode.right != null) {
            sumsStack.add(currentNode.right!! to currentSumIntern)
        }
        if (currentNode.left != null) {
            currentNode = currentNode.left!!
            currentSumIntern += currentNode.value
        } else {
            result.add(currentSumIntern)
            break
        }
    }

    if (sumsStack.isEmpty()) {
        return result
    }
    val nextPair = sumsStack.removeAt(sumsStack.lastIndex)
    return getBranchSum(nextPair.first, result, sumsStack, nextPair.second + nextPair.first.value)
}
