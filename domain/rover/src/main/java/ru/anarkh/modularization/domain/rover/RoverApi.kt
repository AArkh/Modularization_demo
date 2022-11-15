package ru.anarkh.modularization.domain.rover

import retrofit2.http.GET
import retrofit2.http.Query

interface RoverApi {

    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=100&api_key=hXNAtpeNIjyve6a9HqbxXhoaA1DfWfaUOdmDJ0iK
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getRoverPics(
        @Query("api_key") apiKey: String = "hXNAtpeNIjyve6a9HqbxXhoaA1DfWfaUOdmDJ0iK",
        @Query("sol") dayAmount: Int = 100,
    ) : RoverNetModel
}