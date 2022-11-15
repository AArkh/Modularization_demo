package ru.anarkh.modularization.domain.rover

import androidx.annotation.WorkerThread
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoverRepository @Inject constructor(private val api: RoverApi) {

    private var cached: List<RoverPhoto> = listOf()

    @WorkerThread
    suspend fun getApodList(): List<RoverPhoto> {
        if (cached.isEmpty()) {
            val list = api.getRoverPics()
            list.photos.forEach { it.imageUrl = it.imageUrl.replace("http", "https") }
            cached = list.photos
        }
        return cached
    }
}