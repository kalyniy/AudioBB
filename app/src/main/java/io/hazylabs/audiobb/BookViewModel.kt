package io.hazylabs.audiobb
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BookViewModel: ViewModel()
{
    val title: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    public fun title(item:String){
        title.value=item
    }
    val author: MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }
    public fun author(item:String){
        author.value=item
    }
}