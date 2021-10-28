package io.hazylabs.audiobb
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(_context: Context, _bookList: BookList, _listener: View.OnClickListener) : RecyclerView.Adapter<BookAdapter.RecyclerViewHolder>()
{
    private val context = _context
    private val bookList = _bookList
    private val listener = _listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.book_layout, null)
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val title = holder.rItemView.findViewById<TextView>(R.id.textViewTitle)
        val author = holder.rItemView.findViewById<TextView>(R.id.textViewAuthor)
        title.text = bookList.get(position).title
        author.text = bookList.get(position).author

        holder.rItemView.setOnClickListener(listener)
    }

    override fun getItemCount() = bookList.size()+1

    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rItemView = itemView
    }
}