package com.dev.appturistf.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.dev.appturistf.R
import com.dev.appturistf.databinding.FragmentDetailBinding
import com.dev.appturistf.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args:DetailFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  place = args.place

        with(detailBinding){
            com.squareup.picasso.Picasso.get().load(place.urlPicture).into(placeImageView)
            namePlace.text = place.name
            textDescription.text = place.descripcion
            textLocation.text = place.ubicacion
            textTemperature.text = place.temperatura
            textSites.text = place.sitiosrecomendados
        }
    }

}