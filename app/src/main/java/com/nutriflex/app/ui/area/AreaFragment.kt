package com.nutriflex.app.ui.area

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nutriflex.app.databinding.FragmentAreaBinding

class AreaFragment : Fragment() {
    private var _binding: FragmentAreaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAreaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = 2
            override fun createFragment(position: Int): Fragment = when (position) {
                0 -> AreaGymFragment()
                1 -> AreaFoodFragment()
                else -> throw IllegalArgumentException()
            }
        }
        binding.viewPagerArea.adapter = adapter
        TabLayoutMediator(binding.tabLayoutArea, binding.viewPagerArea) { tab, position ->
            tab.text = when (position) {
                0 -> "Gym"
                1 -> "Food"
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 