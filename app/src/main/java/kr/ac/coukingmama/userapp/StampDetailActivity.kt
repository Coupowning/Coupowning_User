package kr.ac.coukingmama.userapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.provider.TedPermissionProvider.context
import kotlinx.android.synthetic.main.activity_stamp_detail.*
import kr.ac.coukingmama.userapp.Adapter.HistoryRecyclerViewAdapter
import kr.ac.coukingmama.userapp.data.user.*


class StampDetailActivity : AppCompatActivity() {

    var storeTitle : String? = null
    var storeId : String? = null
    var storeEvent: String? = null
    var storeLocation : String? = null
    var currStamp : Int = 0
    var image : String? = null
    lateinit var history : List<History>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp_detail)
        var imageView: ImageView? = findViewById<ImageView>(R.id.storeImage)
        // 스토어 정보 연동
        val intent = intent
        var storeData = intent.getSerializableExtra("storelist") as StoreList
        storeTitle = storeData.storeName.toString()
        storeId = storeData.storeId.toString()
        storeEvent = storeData.storeEvent.toString()
        storeLocation = storeData.storeLocation.toString()
        currStamp  = storeData.currStamp
        history = storeData.history
        image = storeData.storeImage
        Glide.with(context).asBitmap().load(image).centerCrop().into(imageView!!)

        storeName.setText(storeTitle)
        benefits.setText(storeEvent)
        address.setText(storeLocation)

        // 스탬프 개수 연동
        for(i in 1..currStamp){
            var stampId = getResources().getIdentifier("stamp_" + i,"id", packageName)
            var iv = findViewById<ImageView>(stampId)
            iv.setImageResource(R.drawable.ic_stamp_image)
        }
        for(i in (currStamp + 1)..10){
            var stampId = getResources().getIdentifier("stamp_" + i,"id", packageName)
            var iv = findViewById<ImageView>(stampId)
            iv.setImageResource(R.drawable.ic_emptystamp)
        }

        // 스탬프 history 연동
        val adapter = HistoryRecyclerViewAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        history.forEach {
            adapter.setData(0, it)
        }

        dBackBt.setOnClickListener {
            finish()
        }
    }
}