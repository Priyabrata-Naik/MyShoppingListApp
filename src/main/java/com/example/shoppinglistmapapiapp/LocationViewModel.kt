package com.example.shoppinglistmapapiapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel(): ViewModel() {

    private val _location = mutableStateOf<LocationData?>(null)
    val location: State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address: State<List<GeocodingResult>> = _address

    fun updateLocation(newLocation: LocationData){
        _location.value = newLocation
    }

    private val apiKey = BuildConfig.API_KEY

    fun fetchAddress(latlng: String){
        try {
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    apiKey
                )
                _address.value = result.results
            }
        }catch(e: Exception){
            Log.d("res1", "${e.cause}  ${e.message}")
        }
    }

}