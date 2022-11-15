package ru.anarkh.modularization.domain.rover

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoverNetModel(
    val photos: List<RoverPhoto>
)

@Serializable
data class RoverPhoto(
    val sol: String,
    val camera: RoverCamera,
    @SerialName("img_src") var imageUrl: String,
    @SerialName("earth_date") val date: String,
    val rover: RoverInfo,
)

@Serializable
data class RoverCamera(
    val id: Int,
    val name: String,
    @SerialName("full_name") val cameraName: String
)

@Serializable
data class RoverInfo(
    val name: String,
    @SerialName("launch_date") val launchDate: String,
    @SerialName("landing_date") val landingDate: String,
)