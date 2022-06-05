package kr.ac.coukingmama.userapp.data.cafe

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kr.ac.coukingmama.userapp.data.user.History
import java.io.Serializable

@Entity(tableName = "cafe_table")
data class Cafe (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var cafeName :String, // 카페 이름
    var cafeIntro : String, // 카페 소개
    var cafeStampNumber : Long, // 카페 최대 스탬프 개수
    var cafeProfitNumber : Long, // 카페 혜택 수집 개수
    var cafeProfitMenu : String, // 카페 혜택 메뉴
    var cafeAddress : String// 카페 주소
)

data class Cafe(
    @SerializedName("storeName") var storeName:String?,
    @SerializedName("storeDesc") var storeDesc:String?,
    @SerializedName("storeLocation") var storeLocation:String?,
    @SerializedName("storeImage") var storeImage:String?,
    @SerializedName("storeEvent") var storeEvent:String?,
    @SerializedName("history") var history: List<History>
) : Serializable