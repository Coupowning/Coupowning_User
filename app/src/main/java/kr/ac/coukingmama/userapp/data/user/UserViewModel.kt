package kr.ac.coukingmama.userapp.data.user

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.ac.coukingmama.userapp.data.RetrofitClient
import retrofit2.Response

class UserViewModel(private val repository: UserRepository) : ViewModel() {
    val myResponse: MutableLiveData<Response<User>> = MutableLiveData()

    fun getUser(userId: String) {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repository.getUser(userId)
            myResponse.value = response
        }
    }
}