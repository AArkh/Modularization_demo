package ru.anarkh.modularization.apod.detail

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import ru.anarkh.core.ui.dpToPx
import ru.anarkh.modularization.apod.detail.impl.R
import javax.inject.Inject

@AndroidEntryPoint
class ApodDetailsFragment : Fragment(R.layout.apod_details_fragment) {

    @Inject
    lateinit var router: ApodDetailsRouter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = router.parseDetailsArguments(requireArguments())

        val image = view.findViewById<AppCompatImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)
        val date = view.findViewById<TextView>(R.id.date)
        val explanation = view.findViewById<TextView>(R.id.explanation)

        title.text = model.title
        date.text = model.data
        explanation.text = model.explanation

        Glide.with(requireContext())
            .asBitmap()
            .load(model.imageUrl)
            .transform(RoundedCorners(requireContext().dpToPx(16)))
            .placeholder(ru.anarkh.modularization.core.ui.R.drawable.placeholder)
            .into(image)
    }
}