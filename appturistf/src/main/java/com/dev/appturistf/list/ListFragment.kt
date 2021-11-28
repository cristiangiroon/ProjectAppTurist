package com.dev.appturistf.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.appturistf.R
import com.dev.appturistf.databinding.FragmentListBinding
import com.dev.appturistf.main.MainActivity
import com.dev.appturistf.model.Place
import com.dev.appturistf.model.PlaceItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var placesAdapter: PlacesAdapter
    private  lateinit var  listPlace: ArrayList<PlaceItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hidenIcon()
        listPlace = loadMockPlaces()
        placesAdapter = PlacesAdapter(listPlace, onItemClicked = {onPlaceClicked(it)})

        listBinding.placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }


    }

    private fun loadMockPlaces(): ArrayList<PlaceItem> {
        val placesString : String = context?.assets?.open("places.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(placesString, Place::class.java)
        return data
    }


    private fun onPlaceClicked(place: PlaceItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(place=place))
    }



}