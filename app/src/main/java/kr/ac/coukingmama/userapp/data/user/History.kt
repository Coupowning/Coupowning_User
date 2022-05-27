package kr.ac.coukingmama.userapp.data.user

import com.google.gson.annotations.SerializedName
import kr.ac.coukingmama.userapp.data.user.Date

data class History(
    @SerializedName("date") var date: Date,
    @SerializedName("amount") var amount:Int
)
