package kr.ac.coukingmama.userapp

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.Outline
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.*
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource

class TabMapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var locationSource: FusedLocationSource // 위치를 반환하는 구현체
    private lateinit var naverMap: NaverMap
    private lateinit var storeFrame : GridLayout
    private val LOCATION_PERMISSION_REQUEST_CODE: Int = 1000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_tab_map, container, false)
        mapView = view.findViewById(R.id.navermap)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        storeFrame = view.findViewById(R.id.storeFrame)

        storeFrame.setOnClickListener {
            var intent = Intent(view.context, InquireStoreActivity::class.java)
            startActivity(intent)
        }

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        return view
    }


@Override
    override fun onRequestPermissionsResult(requestCode:Int, @NonNull permissions:Array<String>,  @NonNull grantResults:IntArray) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            return;
        }
        super.onRequestPermissionsResult(
            requestCode, permissions, grantResults);
    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}