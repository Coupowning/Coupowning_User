package kr.ac.coukingmama.userapp.data.store

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Store(
    @SerializedName("storeName") var storeName:String?,
    @SerializedName("storeDesc") var storeDesc:String?,
    @SerializedName("storeLocation") var storeLocation: StoreLocation,
    @SerializedName("storeImage") var storeImage:ArrayList<String>
) : Serializable