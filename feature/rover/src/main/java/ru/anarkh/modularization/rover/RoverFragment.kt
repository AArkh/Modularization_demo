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
import javax.inject.Inject

@AndroidEntryPoint
class RoverFragment : Fragment(R.layout.rover_fragment) {

    private val viewModel: RoverViewModel by viewModels()

    @Inject
    lateinit var detailsRouter: RoverListRouter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager
        val adapter = RoverListAdapter()
        adapter.setOnImageClickListener = {
            detailsRouter.openRoverDetails(it)
        }
        recyclerView.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.dataFlow.collectLatest {
                adapter.data = it
            }
        }
    }
}