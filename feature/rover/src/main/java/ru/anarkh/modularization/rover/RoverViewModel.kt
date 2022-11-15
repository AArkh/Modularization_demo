package ru.anarkh.modularization.rover

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.anarkh.modularization.domain.rover.RoverRepository
import javax.inject.Inject

@HiltViewModel
internal class RoverViewModel @Inject constructor(
    private val repo: RoverRepository
): ViewModel() {

    val dataFlow = flow {
        try {
            this.emit(repo.getApodList())
        } catch (e: Exception) {
            Log.e("1234567", "failed to get apod", e)
            this.emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)

}