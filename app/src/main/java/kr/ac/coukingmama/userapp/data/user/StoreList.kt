package kr.ac.coukingmama.userapp.data.user

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kr.ac.coukingmama.userapp.data.user.History
import java.io.Serializable

data class StoreList(
    @SerializedName("currStamp") var currStamp:Int,
    @SerializedName("storeId") var storeId:String?,
    @SerializedName("storeName") var storeName:String?,
    @SerializedName("storeLocation") var storeLocation:String?,
    @SerializedName("storeEvent") var storeEvent:String?,
    @SerializedName("history") var history: List<History>
) : Serializable
