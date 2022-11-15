package ru.anarkh.modularization.domain.apod

import android.icu.text.SimpleDateFormat
import androidx.annotation.WorkerThread
import ru.anarkh.core.ui.dayBefore
import ru.anarkh.core.ui.monthBefore
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApodRepository @Inject constructor(
    private val api: ApodApi
) {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    private val cached: MutableList<ApodNetModel> = mutableListOf()

    @WorkerThread
    suspend fun getApodList(): List<ApodNetModel> {
        if (!cached.isEmpty()) return cached // Лень пагинацию херачить))

        val prevEndDate = cached.firstOrNull()?.date
        val endDate = if (prevEndDate != null) {
            simpleDateFormat.parse(prevEndDate).dayBefore()
        } else Calendar.getInstance().time
        val startDate = endDate.monthBefore()

        val list = api.getApodPic(
            startDate = simpleDateFormat.format(startDate),
            endDate = simpleDateFormat.format(endDate),
        ).filterNot { it.mediaType == "video" }
        cached.addAll(0, list)
        return list
    }
}