package com.dev.appturist


import com.google.gson.annotations.SerializedName

data class PlaceItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("sitiosrecomendados")
    val sitiosrecomendados: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("descripcion")
    val descripcion: String
)