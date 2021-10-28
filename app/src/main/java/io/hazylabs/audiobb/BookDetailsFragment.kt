package io.hazylabs.audiobb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class BookDetailsFragment : Fragment() {

    private lateinit var layout: View
    private lateinit var viewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        layout = inflater.inflate(R.layout.fragment_book_details, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)
        val title = layout.findViewById<TextView>(R.id.detailsTitle)
        val author = layout.findViewById<TextView>(R.id.detailsAuthor)
        viewModel.book.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                var book: Book = o!! as Book
                title.text = book.title
                author.text = book.author

            }
        })
        return layout
    }
}