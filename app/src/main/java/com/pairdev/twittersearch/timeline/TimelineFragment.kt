package com.pairdev.twittersearch.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pairdev.twittersearch.databinding.FragmentTimelineBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class TimelineFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: TimelineViewModel by viewModels(factoryProducer = { viewModelFactory })

    private val timelineAdapter = TimelineAdapter()

    private lateinit var binding: FragmentTimelineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimelineBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)

        setupView()
        setupLiveData()

        viewModel.getTimelineFlow()
    }

    private fun setupView() {
        binding.timelineRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = timelineAdapter
        }

    }

    private fun setupLiveData() {
        viewModel.timelineLiveData.observe(viewLifecycleOwner, Observer {
            timelineAdapter.setData(it.orEmpty())
        })
    }
}
