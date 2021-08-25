package easy

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(result: MutableList<String> = mutableListOf()): List<String> {
        result.add(name)
        children.forEach{
            it.depthFirstSearch(result)
        }
        return result
    }
}