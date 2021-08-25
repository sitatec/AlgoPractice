package easy

import kotlin.math.abs

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun findClosestValueInBst(tree: BST, target: Int): Int {
    var currentNode : BST? = tree
    var closestValue = tree.value
    var closestValueCandidate = closestValue

    while (currentNode != null) {
        if(abs(target - closestValueCandidate) < abs(target - closestValue)) {
            closestValue = closestValueCandidate
        }
        currentNode = if(currentNode.value < target) {
            currentNode.right
        } else {
            currentNode.left
        }
        closestValueCandidate = currentNode?.value ?: 0
    }
    return closestValue
}

//        currentTree = when {
//            target < currentTree.value -> {
//                if(currentTree.left == null) {
//                    return currentTree.value
//                }
//                currentTree.left!!
//            }
//            target > currentTree.value -> {
//                if(currentTree.right == null) {
//                    return  currentTree.value
//                }
//                currentTree.right!!
//            }
//            else -> {
//                return currentTree.value
//            }
//        }