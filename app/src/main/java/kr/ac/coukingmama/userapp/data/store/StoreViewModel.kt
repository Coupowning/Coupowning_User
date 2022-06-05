package kr.ac.coukingmama.userapp.data.store

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class StoreViewModel(private val repository: StoreRepository) : ViewModel() {
    val myResponse: MutableLiveData<Response<List<Store>>> = MutableLiveData()

    fun getStore() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repository.getStore()
            myResponse.value = response
        }
    }
}