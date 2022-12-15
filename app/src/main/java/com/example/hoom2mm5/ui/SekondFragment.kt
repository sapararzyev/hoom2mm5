package com.example.hoom2mm5.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.hoom2mm5.App
import com.example.hoom2mm5.ColculateModel
import com.example.hoom2mm5.R
import com.example.hoom2mm5.databinding.FragmentSekondBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SekondFragment : Fragment() {

    private lateinit var controller: NavController
    private lateinit var binding: FragmentSekondBinding
    private val arg by navArgs<SekondFragmentArgs>()
    private val fname by lazy { arg.fname }
    private val sname by lazy { arg.sname }

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
        getReqiest()
        val navHost = requireActivity().supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHost.navController

        binding.tvme.text = fname
        binding.tvyou.text = sname

    }
    private fun getReqiest(){
        App.api.getPerecentage(binding.tvyou.text.toString(),binding.tvme.text.toString()).enqueue(
            object : Callback<ColculateModel> {
                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<ColculateModel>,
                    response: Response<ColculateModel>,
                ) {
                    binding.imgr.text = response.body()?.percentage
                }
                override fun onFailure(call: Call<ColculateModel>, t: Throwable) {
                }
            })
    }
}