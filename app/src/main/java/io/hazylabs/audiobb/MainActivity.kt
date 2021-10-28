package io.hazylabs.audiobb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MainActivity : AppCompatActivity(), BookListFragment.DoubleLayout {
    private val random: Random = Random()
    private val seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val defaultBook = Book("","")
    //lateinit var bookListFragment: BookListFragment

    var twoPane = false
    lateinit var bookViewModel: BookViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        var bookList: BookList = populateBookList(10) // generate 10 random books
        val fragmentContainerView = findViewById<FragmentContainerView>(R.id.container1);
        var bookListFragment = BookListFragment.newInstance(bookList)
        twoPane = findViewById<FragmentContainerView>(R.id.container2) != null
        if(!twoPane)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.container1, bookListFragment)
                .commit()
        }
        else
        {
            var bookDetailsFragment = BookDetailsFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.container1, bookListFragment)
                .add(R.id.container2, bookDetailsFragment)
                .commit()
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
    override fun selectionMade() {
        // only respond if there is a single container
        if (!twoPane)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, BookDetailsFragment())
                .addToBackStack(null)
                .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        // A single way to "clear" the selected book so that
        // if doesn't remain selected. Remove it when the user
        // hits Back
        bookViewModel.book(defaultBook)

    }
}