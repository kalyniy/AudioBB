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


private const val ARG_PARAM1 = "books"
class BookListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var viewModel: BookViewModel
    private lateinit var bookList: BookList
    private lateinit var recycle: RecyclerView
    private lateinit var layout: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            bookList = it.getSerializable(ARG_PARAM1) as BookList
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

        recycle = view.findViewById(R.id.recyclerView)
        recycle.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = CustomAdapter(requireContext(), bookList) {
            updateViewModel(recycle.getChildAdapterPosition(it))
        }
        recycle.adapter = adapter
    }
    private fun updateViewModel(index: Int) {
        ViewModelProvider(requireActivity())
            .get(BookViewModel::class.java)
            var book: Book = bookList.get(index)
        (requireActivity() as DoubleLayout).selectionMade()
    }

    interface DoubleLayout {
        fun selectionMade()
    }
    companion object
    {
        @JvmStatic
        fun newInstance(param1: BookList) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, bookList)
                }
            }
    }
}