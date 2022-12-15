package com.example.hoom2mm5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.hoom2mm5.R
import com.example.hoom2mm5.databinding.FragmentMainBinding


@Suppress("UNREACHABLE_CODE")
class MainFragment : Fragment() {
    private lateinit var controller: NavController
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = requireActivity().supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHost.navController

        binding.calculate.setOnClickListener {
            controller.navigate(
                MainFragmentDirections.actionMainFragmentToSekondFragment2(
                    binding.edMe.text.toString(),
                        binding.edYou.text.toString())
            )
        }
    }
}
