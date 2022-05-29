package kr.ac.coukingmama.userapp.data.user

import com.google.gson.annotations.SerializedName
import kr.ac.coukingmama.userapp.data.user.StoreList

data class User (
    @SerializedName("userId") var userId:String,
    @SerializedName("storeList") var storeList: List<StoreList>

)
