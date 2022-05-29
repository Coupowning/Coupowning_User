package kr.ac.coukingmama.userapp

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private val tabMapFragment by lazy { TabMapFragment() }
    private val tabHomeFragment by lazy { TabHomeFragment() }
    private val tabProfileFragment by lazy { TabProfileFragment() }
    private val LOCATION_PERMISSION_REQUEST_CODE: Int = 1000
    var firestore : FirebaseFirestore? = null
    var userId: String? = null
    var bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
        userId = intent.getStringExtra("userId").toString()
        val toolbar: Toolbar = findViewById(R.id.toolbar) // toolBar를 통해 App Bar 생성
        bundle.putString("userId", "${userId}")
        tabHomeFragment.arguments = bundle
        tabProfileFragment.arguments = bundle
        setSupportActionBar(toolbar) // 커스텀 액션바 적용
        changeFragment(tabHomeFragment)
        getSupportActionBar()!!.setTitle(null)
        firestore = FirebaseFirestore.getInstance() // 파이어베이스 인스턴스 초기화
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)

    }
    private fun initNavigation() { // 탭메뉴 생성
        bnv_main.setSelectedItemId(R.id.tab_home);
        bnv_main.run {
            setOnItemSelectedListener {
                when(it.itemId) {
                    R.id.tab_map -> { // Map 메뉴 클릭 시
                        changeFragment(tabMapFragment)
                    }
                    R.id.tab_home -> {  // Home 메뉴 클릭 시
                        changeFragment(tabHomeFragment)
                    }
                    R.id.tab_profile -> {  // Profile 메뉴 클릭 시
                        changeFragment(tabProfileFragment)
                    }
                }
                true
            }
        }
    }
    private fun changeFragment(fragment: Fragment) { // 화면 변경
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit() }

}