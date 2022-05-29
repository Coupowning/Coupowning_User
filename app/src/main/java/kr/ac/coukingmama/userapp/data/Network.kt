package kr.ac.coukingmama.userapp.data

import kr.ac.coukingmama.userapp.data.user.StoreList
import kr.ac.coukingmama.userapp.data.user.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Network {
    @POST("user")
    @Headers("Content-Type: application/json")
    fun createUser(@Body user: User): Call<User>

    @GET("user/{userId}")
    suspend fun getUser(@Path("userId") userId:String): Response<User>
}


