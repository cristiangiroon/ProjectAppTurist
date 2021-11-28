package com.dev.appturistf.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.appturistf.R
import com.dev.appturistf.model.PlaceItem
import com.squareup.picasso.Picasso

class PlacesAdapter(
    private val placesList: ArrayList<PlaceItem>,
    private val onItemClicked : (PlaceItem)-> Unit
) : RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_item_place, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placesList[position]
        holder.itemView.setOnClickListener { onItemClicked(placesList[position]) }
        holder.bind(place)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val placeName : TextView = view.findViewById(R.id.place_textView)
        private val placeDescription: TextView = view.findViewById(R.id.description_textView)
        private val placeLocation: TextView = view.findViewById(R.id.location_textView)
        private val ratingPlace : TextView = view.findViewById(R.id.rating_textView)
        private val placeRatingBar: RatingBar = view.findViewById(R.id.ratingBar)
        private val picturePlace : ImageView = view.findViewById(R.id.picture_imageView)
        fun bind(place: PlaceItem) {
            placeName.text = place.name
            placeDescription.text = place.descripcion
            placeLocation.text = place.ubicacion
            ratingPlace.text = place.calificacion
            placeRatingBar.rating = (place.calificacion.toFloat() - 1)/5
            Picasso.get().load(place.urlPicture).into(picturePlace);


        }
    }
}