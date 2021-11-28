package com.dev.appturist.detalle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.dev.appturist.R
import com.dev.appturist.databinding.ActivityDetalleBinding
import com.dev.appturist.list.ListPlacesActivity
import com.dev.appturist.model.PlaceItem
import com.squareup.picasso.Picasso

//njhba
class DetalleActivity : AppCompatActivity() {
    private lateinit var detalleBinding : ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val place : PlaceItem = intent.extras?.getSerializable("place") as PlaceItem
        with(detalleBinding){
            Picasso.get().load(place.urlPicture).into(placeImageView)
            namePlace.text = place.name
            textDescription.text = place.descripcion
            textLocation.text = place.ubicacion
            textTemperature.text = place.temperatura
            textSites.text = place.sitiosrecomendados
        }

        val nextButton: Button = detalleBinding.nextButton
        nextButton.setOnClickListener {
            val intent = Intent(this, ListPlacesActivity::class.java)
            startActivity(intent)
        }

    }


}