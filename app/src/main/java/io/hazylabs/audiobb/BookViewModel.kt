package io.hazylabs.audiobb
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BookViewModel: ViewModel()
{
    public val book: MutableLiveData<Book> by lazy{
        MutableLiveData<Book>()
    }
    public fun book(item:Book)
    {
        book.value = item
    }
}