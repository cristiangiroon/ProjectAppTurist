package com.dev.appturistf.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.appturistf.data.PlacesRepository
import com.dev.appturistf.model.Place
import com.dev.appturistf.model.PlaceItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel:ViewModel() {
    private var placesLoad:MutableLiveData<ArrayList<PlaceItem>> = MutableLiveData()
    val onPlacesLoaded: LiveData<ArrayList<PlaceItem>> = placesLoad

    private val repository = PlacesRepository()

    fun getPlacesFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            placesLoad.postValue( repository.getPlaces())
        }
    }
     fun loadMockPlaces(placesString: InputStream?) {
        val placeString = placesString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        placesLoad.value = gson.fromJson(placeString, Place::class.java)
    }

}