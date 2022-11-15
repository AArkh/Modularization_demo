package ru.anarkh.modularization.apod

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import ru.anarkh.modularization.apod.impl.R
import javax.inject.Inject

@AndroidEntryPoint
class ApodFragment : Fragment(R.layout.apod_fragment) {

    private val viewModel: ApodViewModel by viewModels()

    @Inject
    lateinit var detailsRouter: ApodListRouter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.list)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = layoutManager
        val adapter = ApodListAdapter()
        adapter.setOnImageClickListener = {
            detailsRouter.openApodDetails(it)
        }
        recyclerView.adapter = adapter
        lifecycleScope.launchWhenResumed {
            viewModel.dataFlow.collectLatest {
                adapter.data = it
            }
        }
    }
}