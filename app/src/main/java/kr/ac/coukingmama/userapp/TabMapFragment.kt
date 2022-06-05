package kr.ac.coukingmama.userapp

import android.Manifest
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Outline
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.*
import androidx.annotation.NonNull
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.annotations.SerializedName
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.util.MarkerIcons
import kotlinx.android.synthetic.main.coupon_item_list.*
import kr.ac.coukingmama.userapp.data.store.*
import kr.ac.coukingmama.userapp.data.user.UserRepository
import kr.ac.coukingmama.userapp.data.user.UserViewModel
import kr.ac.coukingmama.userapp.data.user.UserViewModelFactory

class TabMapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var locationKr: String
    private lateinit var mapView: MapView
    private lateinit var locationSource: FusedLocationSource // 위치를 반환하는 구현체
    private lateinit var naverMap: NaverMap
    private lateinit var storeFrame : GridLayout
    private val LOCATION_PERMISSION_REQUEST_CODE: Int = 1000
    private lateinit var storeViewModel: StoreViewModel

    private lateinit var storeName :String
    private lateinit var storeDesc :String
    private lateinit var latitude :String
    private lateinit var longitude :String
    private lateinit var storeImage :ArrayList<String>

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_tab_map, container, false)
        mapView = view.findViewById(R.id.navermap)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)


        val storeRepository = StoreRepository()
        val storeViewModelFactory = StoreViewModelFactory(storeRepository)

        storeViewModel = ViewModelProvider(this, storeViewModelFactory).get(StoreViewModel::class.java)
        storeViewModel.getStore()
        storeViewModel.myResponse.observe(viewLifecycleOwner, Observer {
            it.body()!!.forEach {
                longitude = it.storeLocation.longitude.toString()
                latitude = it.storeLocation.latitude.toString()
                storeName = it.storeName.toString()
                storeDesc = it.storeDesc.toString()
                locationKr = it.storeLocation.locationKr
                storeImage = it.storeImage
                drawMarker(it)
            }
        })
        return view
    }

    private fun drawMarker(it: Store) {
        val marker = Marker()
        marker.position = LatLng(it.storeLocation.latitude, it.storeLocation.longitude)
        marker.map = naverMap

        val storeName = it.storeName.toString()
        val storeDesc = it.storeDesc.toString()
        val locationKr = it.storeLocation.locationKr
        val storeImage = it.storeImage

        marker.setOnClickListener {
            val intent = Intent(getActivity(), StoreDetailActivity::class.java)
            intent.putExtra("storeName",  storeName)
            intent.putExtra("storeDesc", storeDesc)
            intent.putExtra("locationKr", locationKr)
            intent.putStringArrayListExtra("storeImage", storeImage)
            startActivity(intent)
            true
        }
    }

    override fun onMapReady(@NonNull naverMap: NaverMap) {
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