package kr.ac.coukingmama.userapp

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_stamp_detail.*
import kr.ac.coukingmama.userapp.Adapter.HistoryRecyclerViewAdapter
import kr.ac.coukingmama.userapp.data.user.History
import kr.ac.coukingmama.userapp.data.user.StoreList
import kr.ac.coukingmama.userapp.data.user.UserViewModel


class StampDetailActivity : AppCompatActivity() {
    var storeTitle : String? = null
    var storeId : String? = null
    var storeEvent: String? = null
    var storeLocation : String? = null
    var currStamp : Int = 0
    lateinit var history : List<History>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stamp_detail)
        val intent = intent
        var storeData = intent.getSerializableExtra("storelist") as StoreList
        storeTitle = storeData.storeName.toString()
        storeId = storeData.storeId.toString()
        storeEvent = storeData.storeEvent.toString()
        storeLocation = storeData.storeLocation.toString()
        currStamp  = storeData.currStamp
        history = storeData.history

        storeName.setText(storeTitle)
        benefits.setText(storeEvent)
        address.setText(storeLocation)

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
        Log.d("history", history.toString())
        val adapter = HistoryRecyclerViewAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        history.forEach {
            adapter.setData(0, it)
            Log.d("history", it.toString())
        }


        storeView.setOnClickListener {
            TODO("가게보기 클릭 시 가게 페이지로 이동 구현")
        }
        dBackBt.setOnClickListener {
            finish()
        }
    }
}