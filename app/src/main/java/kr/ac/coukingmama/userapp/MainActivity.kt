package kr.ac.coukingmama.userapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tabMapFragment by lazy { TabMapFragment() }
    private val tabHomeFragment by lazy { TabHomeFragment() }
    private val tabProfileFragment by lazy { TabProfileFragment() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigation()
        val toolbar: Toolbar = findViewById(R.id.toolbar) // toolBar를 통해 App Bar 생성
        setSupportActionBar(toolbar) // 커스텀 액션바 적용
        changeFragment(tabHomeFragment)
        getSupportActionBar()!!.setTitle(null)
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