package ru.anarkh.modularization.domain.apod

import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {

    @GET("planetary/apod")
    suspend fun getApodPic(
        @Query("api_key") apiKey: String = "hXNAtpeNIjyve6a9HqbxXhoaA1DfWfaUOdmDJ0iK",
        @Query("start_date") startDate: String, // 2022-10-10
        @Query("end_date") endDate: String, // 2022-11-01
    ) : List<ApodNetModel>
}