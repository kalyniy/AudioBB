package io.hazylabs.audiobb

import java.util.ArrayList


class BookList {
    private val list: MutableList<Book>
    private var size: Int
    fun add(book: Book) {
        list.add(book)
        size++
    }

    fun remove(book: Book) {
        if (size != 0) {
            list.remove(book)
            size--
        }
    }

    operator fun get(index: Int): Book {
        return list[index]
    }

    fun size(): Int {
        return size
    }

    init {
        list = ArrayList()
        size = 0
    }
}
