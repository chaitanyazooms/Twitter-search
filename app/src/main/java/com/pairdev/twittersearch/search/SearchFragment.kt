package com.pairdev.twittersearch.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pairdev.twittersearch.R
import com.pairdev.twittersearch.databinding.FragmentSearchBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: SearchViewModel by this.viewModels(factoryProducer = { viewModelFactory })

    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)

        setupView()
        setupLiveData()
    }

    private fun setupLiveData() {
        viewModel.getNavigationLiveData().observe(viewLifecycleOwner, Observer { navigateTo ->
            if (navigateTo == SearchViewModel.NAVIGATE_TO_TIMELINE) {
                findNavController().navigate(R.id.action_searchFragment_to_timelineFragment)
            }
        })
    }

    private fun setupView() {
        binding.searchButton.setOnClickListener {
            val searchText = binding.searchTextInputLayout.editText?.text.toString()

            viewModel.onSearchClick(searchText)
        }
    }
}
