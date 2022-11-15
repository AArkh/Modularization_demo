package ru.anarkh.modularization.domain.apod

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApodNetModel(
    val copyright: String?,
    val date: String,
    val explanation: String?,
    val hdurl: String?, // null for video
    @SerialName("media_type") val mediaType: String, // image
    val title: String,
    val url: String,
)