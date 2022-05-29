package kr.ac.coukingmama.userapp.data.user


import android.util.Log
import kr.ac.coukingmama.userapp.data.RetrofitClient
import retrofit2.Response


class UserRepository {
    suspend fun getUser(userId:String): Response<User> {
        return RetrofitClient.apiService.getUser(userId)
    }
}