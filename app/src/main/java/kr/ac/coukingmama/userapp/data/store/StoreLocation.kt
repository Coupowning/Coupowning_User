package kr.ac.coukingmama.userapp.data.store

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StoreLocation(
    @SerializedName("longitude") var longitude: Double,
    @SerializedName("locationKr") var locationKr:String,
    @SerializedName("latitude") var latitude:Double
) : Serializable
