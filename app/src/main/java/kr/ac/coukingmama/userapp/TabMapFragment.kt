package kr.ac.coukingmama.userapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap

class TabMapFragment : Fragment() {

    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_tab_map, container, false)
    }
}