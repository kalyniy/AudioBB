package io.hazylabs.audiobb

import android.os.Bundle
import android.widget.Toast
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


private const val ARG_PARAM1 = "items"
class BookListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: BookList? = null
    private lateinit var viewModel: BookViewModel
    private lateinit var recycle: RecyclerView
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as BookList?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        layout =  inflater.inflate(R.layout.fragment_book_list, container, false)
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(BookViewModel::class.java)

        recycle = layout.findViewById<RecyclerView>(R.id.recyclerView)
        recycle.layoutManager = GridLayoutManager(layout.context, 3)

        val onClickListener = View.OnClickListener {
            val index = recycle.getChildAdapterPosition(it)
            val selectedBook = param1!![index];
            val title = (selectedBook.title)!!
            val author = (selectedBook.author)!!
            viewModel.title(title)
            viewModel.author(author)
        }
        recycle.adapter = BookAdapter(param1!!, onClickListener)


    }
    companion object
    {
        @JvmStatic
        fun newInstance(param1: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, param1)
                }
            }
    }
}