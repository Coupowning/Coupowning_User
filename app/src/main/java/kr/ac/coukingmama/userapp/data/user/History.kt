package kr.ac.coukingmama.userapp.data.user

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kr.ac.coukingmama.userapp.data.user.Date
import java.io.Serializable


data class History(
    @SerializedName("date") var date: Date,
    @SerializedName("amount") var amount:Int
) : Serializable
