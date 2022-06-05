package kr.ac.coukingmama.userapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_inquire_store.*
import kr.ac.coukingmama.userapp.Adapter.StoreProfileAdapter
import kr.ac.coukingmama.userapp.data.store.StoreProfile
import kr.ac.coukingmama.userapp.data.store.StoreViewModel
import kr.ac.coukingmama.userapp.databinding.ActivityInquireStoreBinding

class InquireStoreActivity : AppCompatActivity() {
    lateinit var storeProfileAdapter: StoreProfileAdapter
    lateinit var binding: ActivityInquireStoreBinding
    private lateinit var backArrow: ImageView
    val datas = mutableListOf<StoreProfile>()
    private lateinit var mPostViewModel: StoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInquireStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mPostViewModel = ViewModelProvider(this).get(StoreViewModel::class.java)

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

        datas.apply {
            add(StoreProfile(img = R.drawable.coffee_pic))
            add(StoreProfile(img = R.drawable.coffee_pic))
            add(StoreProfile(img = R.drawable.coffee_pic))
            add(StoreProfile(img = R.drawable.coffee_pic))
            add(StoreProfile(img = R.drawable.coffee_pic))

            storeProfileAdapter.datas = datas
            storeProfileAdapter.notifyDataSetChanged()

        }
    }
}