package io.hazylabs.audiobb
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BookViewModel: ViewModel()
{
    private val title: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    fun title(item:String){
        title.value=item
    }
    private val author: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    fun author(item:String){
        author.value=item
    }
}