package easy

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {
    var currentNode: LinkedList? = linkedList

    while (currentNode != null){
        while(currentNode.value == currentNode.next?.value){
            currentNode.next = currentNode.next!!.next
        }
        currentNode = currentNode.next
    }

    return linkedList
}
