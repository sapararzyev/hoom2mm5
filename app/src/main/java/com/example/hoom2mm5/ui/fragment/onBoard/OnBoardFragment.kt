package com.example.hoom2mm5.ui.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hoom2mm5.R
import com.example.hoom2mm5.databinding.FragmentOnBoardBinding
import com.example.hoom2mm5.model.AktivityMainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardFragment : Fragment(),onBoardAdapter.getstart {

    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var adapter: onBoardAdapter
    private val viewModel: AktivityMainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = onBoardAdapter(this)
        binding.onBoardPager.adapter = adapter
    }

    override fun start() {
        viewModel.saveBoardState()
        findNavController().navigate(R.id.mainFragment)
    }
}


