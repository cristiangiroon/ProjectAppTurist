package com.dev.appturistf.data

class PlacesRepository {
    suspend fun getPlaces() = ApiFactory.retrofit.getPlaces()
}