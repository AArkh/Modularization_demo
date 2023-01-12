package ru.anarkh.details_2.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoverDetailsPhoto(
    val sol: String,
    val camera: RoverDetailsCamera,
    @SerialName("img_src") var imageUrl: String,
    @SerialName("earth_date") val date: String,
    val rover: RoverDetailsInfo,
)

@Serializable
data class RoverDetailsCamera(
    val id: Int,
    val name: String,
    @SerialName("full_name") val cameraName: String
)

@Serializable
data class RoverDetailsInfo(
    val name: String,
    @SerialName("launch_date") val launchDate: String,
    @SerialName("landing_date") val landingDate: String,
)