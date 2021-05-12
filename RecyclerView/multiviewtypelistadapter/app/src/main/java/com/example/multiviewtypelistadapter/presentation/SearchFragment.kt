package com.example.multiviewtypelistadapter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.multiviewtypelistadapter.R
import com.example.multiviewtypelistadapter.base.BindingFragment
import com.example.multiviewtypelistadapter.databinding.FragmentSearchBinding

class SearchFragment : BindingFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    private val searchViewModel by viewModels<SearchViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}
