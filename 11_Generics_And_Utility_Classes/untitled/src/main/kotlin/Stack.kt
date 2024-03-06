import java.util.*

open class Stack<T> {

    private val itemList = mutableListOf<T>()

    fun push(item: T) {
        itemList.add(itemList.count(), item)
    }

    fun pop():T? {
        return if (itemList.isNotEmpty()) {
            itemList.removeAt(itemList.count() - 1)
        } else null
    }

    fun isEmpty(): Boolean {
        return itemList.size <= 0
    }
}