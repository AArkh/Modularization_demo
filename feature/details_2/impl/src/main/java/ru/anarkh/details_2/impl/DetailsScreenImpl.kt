package ru.anarkh.details_2.impl

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.anarkh.details_2.api.DetailsNetModel
import ru.anarkh.details_2.api.DetailsScreenApi
import ru.anarkh.details_2.api.RoverDetailsPhoto
import javax.inject.Inject

class DetailsScreenImpl @Inject constructor(): DetailsScreenApi {

    override fun getDetailsScreen(model: DetailsNetModel): Fragment {
        val fragment = Details2Fragment()
        fragment.arguments = createBundle(model)
        return fragment
    }

    override fun getDetailsScreen(photo: RoverDetailsPhoto): Fragment {
        val fragment = Details2Fragment()
        fragment.arguments = createBundle(photo)
        return fragment
    }

    private fun createBundle(roverDetailsPhoto: RoverDetailsPhoto): Bundle {
        val bundle = Bundle()
        val explanation = "Image captured by ${roverDetailsPhoto.rover.name} at ${roverDetailsPhoto.sol} sol with ${roverDetailsPhoto.camera.cameraName}"
        bundle.putString(APOD_TITLE_KEY, "${roverDetailsPhoto.rover.name}#${roverDetailsPhoto.sol}#${roverDetailsPhoto.camera.name}")
        bundle.putString(APOD_DATE_KEY, roverDetailsPhoto.date)
        bundle.putString(APOD_EXPLANATION_KEY, explanation)
        bundle.putString(APOD_IMAGE_URL_KEY, roverDetailsPhoto.imageUrl)
        return bundle
    }

    private fun createBundle(apodNetModel: DetailsNetModel): Bundle {
        val bundle = Bundle()
        bundle.putString(APOD_TITLE_KEY, apodNetModel.title)
        bundle.putString(APOD_DATE_KEY, apodNetModel.date)
        bundle.putString(APOD_EXPLANATION_KEY, apodNetModel.explanation)
        bundle.putString(APOD_IMAGE_URL_KEY, apodNetModel.url)
        return bundle
    }

    companion object {
        const val APOD_TITLE_KEY = "APOD_TITLE_KEY"
        const val APOD_DATE_KEY = "APOD_DATE_KEY"
        const val APOD_EXPLANATION_KEY = "APOD_EXPLANATION_KEY"
        const val APOD_IMAGE_URL_KEY = "APOD_IMAGE_URL_KEY"
    }
}