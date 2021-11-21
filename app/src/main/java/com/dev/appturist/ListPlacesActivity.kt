package com.dev.appturist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListPlacesActivity : AppCompatActivity() {
    private  lateinit var  listPlace: ArrayList<PlaceItem>
    private lateinit var placesAdapter: PlacesAdapter
    private lateinit var placesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_places)

        placesRecyclerView = findViewById(R.id.places_recycler_view)

       // listPlace = createMockPlaces()
        listPlace = loadMockPlaces()
        placesAdapter = PlacesAdapter(listPlace)

        placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }

    }

    private fun loadMockPlaces(): ArrayList<PlaceItem> {
        val placesString : String = applicationContext.assets.open("places.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(placesString, Place::class.java)
        return data
    }


   /* private fun createMockPlaces(): ArrayList<Place>{
    return arrayListOf(
        Place(name = "Popayán",descripcion = "La ciudad blanca",
            ubicacion="Departamento del Cauca",
            calificacion= "5.0",
            temperatura="24.5",
            sitiosrecomendados ="Torre del reloj, Pueblito patojo",
            urlPicture= "https://media.traveler.es/photos/61376f8bd4923f67e298ef5b/master/w_1600%2Cc_limit/130738.jpg"),
        Place(name = "Cali",descripcion = "La ciudad blanca",
            ubicacion="Departamento del Valle",
            calificacion= "3.0",
            temperatura="24.5",
            sitiosrecomendados ="Torre del reloj, Pueblito patojo",
            urlPicture= "https://blogs.iadb.org/ciudades-sostenibles/wp-content/uploads/sites/17/2016/04/cali-3.jpg")
        )
    }*/
}