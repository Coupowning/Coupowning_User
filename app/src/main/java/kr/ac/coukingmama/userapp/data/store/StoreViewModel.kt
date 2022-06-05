package kr.ac.coukingmama.userapp.data.cafe

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CafeViewModel(application: Application): AndroidViewModel(application)  {

    val readAllPost: LiveData<List<Cafe>>
    val getCount: LiveData<Int>?
    private val repository: CafeRepository

    init {
        val postDao = CafeAppDatabase.getDatabase(application)!!.CafeDAO()
        repository = CafeRepository(postDao)
        readAllPost = repository.readAllPost
        getCount = repository.getCount
    }
    fun addPost(cafe:Cafe){
        viewModelScope.launch(Dispatchers.IO){
            repository.addPost(cafe)
        }
    }

    fun deletePost(id:Int){
        viewModelScope.launch(Dispatchers.IO){
            repository.deletePost(id)
        }
    }

    fun updatePost(cafe:Cafe){
        viewModelScope.launch(Dispatchers.IO){
            repository.updatePost(cafe)
        }
    }
}