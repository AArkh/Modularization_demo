package ru.anarkh.modularization.apod.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.anarkh.modularization.domain.apod.ApodNetModel
import ru.anarkh.modularization.domain.rover.RoverPhoto

interface ApodDetailsRouter {

    fun openApodDetails(apodNetModel: ApodNetModel)

    fun createApodDetailsFragment(apodNetModel: ApodNetModel): Fragment {
        val fragment = ApodDetailsFragment()
        fragment.arguments = createBundle(apodNetModel)
        return fragment
    }

    fun createApodDetailsFragment(roverPhoto: RoverPhoto): Fragment {
        val fragment = ApodDetailsFragment()
        fragment.arguments = createBundle(roverPhoto)
        return fragment
    }

    private fun createBundle(apodNetModel: ApodNetModel): Bundle {
        val bundle = Bundle()
        bundle.putString(APOD_TITLE_KEY, apodNetModel.title)
        bundle.putString(APOD_DATE_KEY, apodNetModel.date)
        bundle.putString(APOD_EXPLANATION_KEY, apodNetModel.explanation)
        bundle.putString(APOD_IMAGE_URL_KEY, apodNetModel.url)
        return bundle
    }

    private fun createBundle(roverPhoto: RoverPhoto): Bundle {
        val bundle = Bundle()
        val explanation = "Image captured by ${roverPhoto.rover.name} at ${roverPhoto.sol} sol with ${roverPhoto.camera.cameraName}"
        bundle.putString(APOD_TITLE_KEY, "${roverPhoto.rover.name}#${roverPhoto.sol}#${roverPhoto.camera.name}")
        bundle.putString(APOD_DATE_KEY, roverPhoto.date)
        bundle.putString(APOD_EXPLANATION_KEY, explanation)
        bundle.putString(APOD_IMAGE_URL_KEY, roverPhoto.imageUrl)
        return bundle
    }

    fun parseDetailsArguments(bundle: Bundle): ApodDetailsUiModel {
        return ApodDetailsUiModel(
            imageUrl = bundle.getString(APOD_IMAGE_URL_KEY, ""),
            title = bundle.getString(APOD_TITLE_KEY, ""),
            data = bundle.getString(APOD_DATE_KEY, ""),
            explanation = bundle.getString(APOD_EXPLANATION_KEY, ""),
        )
    }

    private companion object {
        private const val APOD_TITLE_KEY = "APOD_TITLE_KEY"
        private const val APOD_DATE_KEY = "APOD_DATE_KEY"
        private const val APOD_EXPLANATION_KEY = "APOD_EXPLANATION_KEY"
        private const val APOD_IMAGE_URL_KEY = "APOD_IMAGE_URL_KEY"
    }
}