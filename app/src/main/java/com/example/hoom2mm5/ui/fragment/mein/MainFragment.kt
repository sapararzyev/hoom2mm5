package com.example.hoom2mm5.ui.fragment.mein

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.hoom2mm5.model.AktivityMainViewModel
import com.example.hoom2mm5.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: AktivityMainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
        ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculate.setOnClickListener {
            getReqiest()
        } }

    private fun getReqiest() {
        viewModel.getRequest(binding.edMe.text.toString(),binding.edYou.text.toString())
            .observe(viewLifecycleOwner) {
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToSekondFragment(
                        binding.edMe.text.toString(), it.percentage, binding.edYou.text.toString())
                )
            } }
}
