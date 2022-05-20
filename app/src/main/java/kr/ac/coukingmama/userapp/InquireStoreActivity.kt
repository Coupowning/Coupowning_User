package kr.ac.coukingmama.userapp

import android.app.Activity
import android.os.Bundle
import android.widget.GridLayout
import android.widget.ImageView

class InquireStoreActivity:Activity() {

    private lateinit var backArrow : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inquire_store)

        backArrow = findViewById(R.id.backArrow)
        backArrow.setOnClickListener {
            finish()
        }

    }
}