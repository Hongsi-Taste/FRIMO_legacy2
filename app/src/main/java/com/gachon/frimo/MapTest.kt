package com.gachon.frimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import com.gachon.frimo.databinding.ActivityMapTestBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback

class MapTest : AppCompatActivity(), OnMapReadyCallback {
    //map불러오기
    companion object{
        lateinit var naverMap: NaverMap
    }
    private lateinit var mapView: MapView
    private lateinit var binding: ActivityMapTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapTestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //지도
        naverMap.mapType = NaverMap.MapType.Basic //지도유형
        mapView = binding.mapViewXml //연결
        mapView.onCreate(savedInstanceState) //라이브사이클매칭
        mapView.getMapAsync(this) //API호출준비
    }

//map시작할때 중앙좌표, 확대 설정
    override fun onMapReady(p0: NaverMap) {
        var campos = CameraPosition(
            LatLng(34.38, 128.55),9.0
        )
        naverMap.cameraPosition = campos
    }

//지도 라이프사이클 호출용
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