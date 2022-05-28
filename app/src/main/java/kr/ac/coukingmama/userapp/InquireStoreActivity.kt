package kr.ac.coukingmama.userapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import kr.ac.coukingmama.userapp.databinding.ActivityInquireStoreBinding

class InquireStoreActivity : AppCompatActivity() {
    lateinit var profileAdapter: ProfileAdapter
    lateinit var binding: ActivityInquireStoreBinding
    private lateinit var backArrow: ImageView
    val datas = mutableListOf<ProfileData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInquireStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
        backArrow = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
        }
    }
    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView.adapter = profileAdapter

        datas.apply {
            add(ProfileData(img = R.drawable.coffee_pic))
            add(ProfileData(img = R.drawable.coffee_pic))
            add(ProfileData(img = R.drawable.coffee_pic))
            add(ProfileData(img = R.drawable.coffee_pic))
            add(ProfileData(img = R.drawable.coffee_pic))

            profileAdapter.datas = datas
            profileAdapter.notifyDataSetChanged()

        }
    }
}