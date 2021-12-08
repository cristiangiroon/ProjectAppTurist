package com.dev.appturistf.data

import com.dev.appturistf.model.Place
import retrofit2.http.GET

interface ApiService {

    @GET("cristiangiroon/TuristApp2/places")
    suspend fun getPlaces():Place
}