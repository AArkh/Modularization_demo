package ru.anarkh.details_2.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailsNetModel(
    val copyright: String?,
    val date: String,
    val explanation: String?,
    val hdurl: String?, // null for video
    @SerialName("media_type") val mediaType: String, // image
    val title: String,
    val url: String,
)