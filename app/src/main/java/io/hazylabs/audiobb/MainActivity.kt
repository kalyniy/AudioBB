package io.hazylabs.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    private val random: Random = Random()
    private val seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var bookList: BookList = populateBookList(10) // generate 10 random books

        for (i in 0 until bookList.size())
        {
            var book: Book = bookList.get(i);
            Log.d("book:", book.toString());
        }
    }
    fun randomString(length: Int): String {
        var retval = ""
        for (i in 0 until length) {
            val r: Int = random.nextInt(length)
            val c: Char = seed[r]
            retval += c
        }
        return retval
    }

    fun populateBookList(limit: Int): BookList {
        val list = BookList()
        for (i in 0 until limit) {
            val title = randomString(10)
            val author = randomString(7)
            val book = Book(title, author)
            list.add(book)
        }
        return list
    }
}