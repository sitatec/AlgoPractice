package medium

open class BST(var value: Int) {
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int): BST {
        // Write your code here.
        // Do not edit the return statement of this method.
        insertValue(this, value)
        return this
    }

    private fun insertValue(node: BST, value: Int) {
        if (value < node.value) {
            if (node.left == null) {
                node.left = BST(value)
            } else {
                insertValue(node.left!!, value)
            }
        } else {
            if (node.right == null) {
                node.right = BST(value)
            } else {
                insertValue(node.right!!, value)
            }
        }
    }

    fun contains(value: Int): Boolean {
        // Write your code here.
        return containsValue(this, value)
    }

    private fun containsValue(node: BST, value: Int): Boolean {
        return if (node.value == value) {
            true
        } else if (value < node.value) {
            if (node.left != null) {
                containsValue(node.left!!, value)
            } else {
                false
            }
        } else {
            if (node.right != null) {
                containsValue(node.right!!, value)
            } else {
                false
            }
        }
    }

    fun remove(value: Int): BST {
        // Write your code here.
        // Do not edit the return statement of this method.
        removeValue(this, value)
        return this
    }

    private fun getMinValue(): Int {
        if (left != null) {
            return left!!.getMinValue()
        }
        return value
    }

    private fun removeValue(node: BST, value: Int, parentNode: BST? = null) {
        if (value == node.value) {
            if (node.left != null && node.right != null) {
                node.value = node.right!!.getMinValue()
                removeValue(node.right!!, node.value, node)
            } else if (parentNode == null) {
                if (node.left != null) {
                    node.value = node.left!!.value
                    node.right = node.left!!.right
                    node.left = node.left!!.left
                } else if (node.right != null) {
                    node.value = node.right!!.value
                    node.left = node.right!!.left
                    node.right = node.right!!.right
                }
            } else if(parentNode.left == node){
                parentNode.left = if(node.left != null) node.left else node.right
            } else if(parentNode.right == node) {
                parentNode.right = if(node.right != null) node.right else node.left
            }
        } else if (value > node.value) {
            if(node.right != null) {
                removeValue(node.right!!, value, node)
            }
        } else {
            if(node.left != null) {
                removeValue(node.left!!, value, node)
            }
        }
    }

}
