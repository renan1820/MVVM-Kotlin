package git.portifilio.renan.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import git.portifilio.renan.mvvm.model.Blog

class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<Blog>>()
    private var newlist = arrayListOf<Blog>()

    fun addList(blog: Blog){
        newlist.add(blog)
        lst.value=newlist
    }

    fun removeList(blog: Blog){
        newlist.remove(blog)
        lst.value=newlist
    }

    fun getSizeList(): Int{
        return newlist.size
    }

}