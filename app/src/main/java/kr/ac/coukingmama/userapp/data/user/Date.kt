package kr.ac.coukingmama.userapp.data.user

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("_seconds") var _seconds:Int,
    @SerializedName("_nanoseconds") var _nanoseconds:Int
)
