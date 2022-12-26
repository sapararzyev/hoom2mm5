package com.example.hoom2mm5.ui.fragment.second

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.hoom2mm5.databinding.FragmentSekondBinding

class SekondFragment : Fragment() {

    private lateinit var binding: FragmentSekondBinding
    private val args by navArgs <SekondFragmentArgs>()
    private val firstName by lazy { args.fname }
    private val percentage by lazy { args.percentage }
    private val secondName by lazy { args.sname }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSekondBinding.inflate(layoutInflater)
        return binding.root
    }
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvme.text = firstName
        binding.tvLive.text = "$percentage%"
        binding.tvyou.text = secondName
        binding.btnSecont.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}