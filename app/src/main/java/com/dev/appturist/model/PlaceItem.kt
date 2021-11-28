package com.dev.appturist.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
): Serializable