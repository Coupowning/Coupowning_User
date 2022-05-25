package kr.ac.coukingmama.userapp

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_inquire_store.*
import kr.ac.coukingmama.userapp.databinding.ActivityInquireStoreBinding


class InquireStoreActivity:Activity() {

    lateinit var profileAdapter: ProfileAdapter
    val datas = mutableListOf<ProfileData>()
    lateinit var binding: ActivityInquireStoreBinding
    private lateinit var backArrow: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inquire_store)

        initRecycler()

        backArrow = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
        }
    }

    private fun initRecycler() {
        profileAdapter = ProfileAdapter(this)
        binding = ActivityInquireStoreBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = profileAdapter

        datas.apply {
            add(ProfileData(img = R.drawable.coffee_pic))
            add(ProfileData(img = R.drawable.coffee_pic))
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