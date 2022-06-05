package kr.ac.coukingmama.userapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_store_detail.*
import kotlinx.android.synthetic.main.activity_store_detail.storeName
import kr.ac.coukingmama.userapp.Adapter.StoreProfileAdapter
import kr.ac.coukingmama.userapp.data.store.StoreProfile
import kr.ac.coukingmama.userapp.databinding.ActivityStoreDetailBinding

class StoreDetailActivity : AppCompatActivity() {
    lateinit var storeProfileAdapter: StoreProfileAdapter
    lateinit var binding: ActivityStoreDetailBinding
    private lateinit var backArrow: ImageView
    val datas = mutableListOf<StoreProfile>()

    var StoreName : String? = null
    var StoreDesc: String? = null
    var LocationKr: String? = null
    lateinit var StoreImage:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()

        backArrow = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
        }
    }
    private fun initRecycler() {
        storeProfileAdapter = StoreProfileAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = storeProfileAdapter

        StoreImage = intent.getStringArrayListExtra("storeImage")!!
        StoreName = intent.getStringExtra("storeName")
        StoreDesc = intent.getStringExtra("storeDesc")
        LocationKr = intent.getStringExtra("locationKr")

        datas.apply {
            StoreImage.forEach {
                x->
                datas.add(StoreProfile(image = x))
            }
            storeProfileAdapter.datas = datas
            storeProfileAdapter.notifyDataSetChanged()
        }

        storeName.setText(StoreName.toString())
        storeProfitMenu.setText(StoreDesc.toString())
        storeAddress.setText(LocationKr.toString())
    }
}