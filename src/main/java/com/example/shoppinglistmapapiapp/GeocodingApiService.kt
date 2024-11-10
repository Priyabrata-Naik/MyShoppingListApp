package com.example.shoppinglistmapapiapp

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GeocodingApiService {

    @GET("maps/api/geocode/json?")
    suspend fun getAddressFromCoordinates(
        @Query("latlng") latlng: String,
        @Query("key") apiKey: String,
        @Header("X-Android-Package") androidPackage: String = "com.example.shoppinglistmapapiapp",
        @Header("X-Android-Cert") sha1: String = "6020F6C90750020EFA5AF090D0E64CEF7901D2AE",
    ): GeocodingResponse

}