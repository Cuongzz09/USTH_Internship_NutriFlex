package com.nutriflex.app.ui.kcal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.nutriflex.app.databinding.FragmentKcalBinding

class KcalFragment : Fragment() {
    private var _binding: FragmentKcalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKcalBinding.inflate(inflater, container, false)
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
                0 -> KcalBeforeFragment()
                1 -> KcalAfterFragment()
                else -> throw IllegalArgumentException()
            }
        }
        binding.viewPagerKcal.adapter = adapter
        TabLayoutMediator(binding.tabLayoutKcal, binding.viewPagerKcal) { tab, position ->
            tab.text = when (position) {
                0 -> "Before Cardio"
                1 -> "After Cardio"
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 