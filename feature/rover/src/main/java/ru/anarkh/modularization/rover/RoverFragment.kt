package ru.anarkh.modularization.rover

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ru.anarkh.details_2.api.DetailsScreenApi
import ru.anarkh.details_2.api.RoverDetailsCamera
import ru.anarkh.details_2.api.RoverDetailsInfo
import ru.anarkh.details_2.api.RoverDetailsPhoto
import ru.anarkh.navigation_2.Navigator
import javax.inject.Inject

@AndroidEntryPoint
class RoverFragment : Fragment(R.layout.rover_fragment) {

    private val viewModel: RoverViewModel by viewModels()

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var detailsScreen: DetailsScreenApi

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager
        val adapter = RoverListAdapter()
        adapter.setOnImageClickListener = { photo ->
            //think about better models usage
            photo.apply {
                navigator.openScreen(
                    detailsScreen.getDetailsScreen(
                        RoverDetailsPhoto(
                            sol = sol,
                            camera = RoverDetailsCamera(camera.id, camera.name, camera.cameraName),
                            imageUrl = imageUrl,
                            date = date,
                            rover = RoverDetailsInfo(rover.name, rover.launchDate, rover.landingDate)
                        )
                    )
                )
            }
        }
        recyclerView.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.dataFlow.collectLatest {
                adapter.data = it
            }
        }
    }
}