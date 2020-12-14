package com.happinesea.app.gmapplus

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    private lateinit var mUiSettings:UiSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun isChecked(id: Int): Boolean {
        return (findViewById<View>(id) as CheckBox).isChecked
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // set ui
        mUiSettings = mMap.uiSettings

        // Keep the UI Settings state in sync with the checkboxes.
        /*mUiSettings.isZoomControlsEnabled = isChecked(R.id.zoom_buttons_toggle)
        mUiSettings.isCompassEnabled = isChecked(R.id.compass_toggle)
        mUiSettings.isMyLocationButtonEnabled = isChecked(R.id.mylocationbutton_toggle)
        mUiSettings.isScrollGesturesEnabled = isChecked(R.id.scroll_toggle)
        mUiSettings.isZoomGesturesEnabled = isChecked(R.id.zoom_gestures_toggle)
        mUiSettings.isTiltGesturesEnabled = isChecked(R.id.tilt_toggle)
        mUiSettings.isRotateGesturesEnabled = isChecked(R.id.rotate_toggle)*/
        mUiSettings.isZoomControlsEnabled = true
        mUiSettings.isCompassEnabled = true
        mUiSettings.isMyLocationButtonEnabled = true
        mUiSettings.isScrollGesturesEnabled = true
        mUiSettings.isZoomGesturesEnabled = true
        mUiSettings.isTiltGesturesEnabled = true
        mUiSettings.isRotateGesturesEnabled = true

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID)
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Happinesea GMap Plus"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}