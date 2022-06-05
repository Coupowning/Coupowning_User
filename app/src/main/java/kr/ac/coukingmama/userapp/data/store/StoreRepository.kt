package kr.ac.coukingmama.userapp.data.store

import kr.ac.coukingmama.userapp.data.RetrofitClient
import retrofit2.Response

class StoreRepository {
    suspend fun getStore(): Response<List<Store>> {
        return RetrofitClient.apiService.getStore()
    }
}