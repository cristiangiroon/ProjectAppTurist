package com.dev.appturistf.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.appturistf.databinding.FragmentListBinding
import com.dev.appturistf.ui.main.MainActivity
import com.dev.appturistf.model.PlaceItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private  lateinit var listViewModel: ListViewModel
    private lateinit var placesAdapter: PlacesAdapter
    private   var  listPlace: ArrayList<PlaceItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hidenIcon()
        // listViewModel.loadMockPlaces(context?.assets?.open("places.json"))
        listViewModel.getPlacesFromServer()
        listViewModel.onPlacesLoaded.observe(viewLifecycleOwner,{ result ->
            onPlacesLoadedSubscribe(result)

        })

        placesAdapter = PlacesAdapter(listPlace!!, onItemClicked = {onPlaceClicked(it)})


        listBinding.placesRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placesAdapter
            setHasFixedSize(false)
        }

    }

    private fun onPlacesLoadedSubscribe(result: ArrayList<PlaceItem>?) {
    result?.let { listPlace ->
        placesAdapter.appendItems(listPlace)
       // this.listPlace = listPlace
       // placesAdapter.notifyDataSetChanged()

    }


    }

    private fun onPlaceClicked(place: PlaceItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(place=place))
    }

}