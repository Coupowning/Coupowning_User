package kr.ac.coukingmama.userapp.data.user

import com.google.firebase.Timestamp
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class Date(
    @SerializedName("_seconds") var _seconds:Long,
    @SerializedName("_nanoseconds") var _nanoseconds:Long
) : Serializable
