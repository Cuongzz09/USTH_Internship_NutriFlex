package com.nutriflex.app.ui.daily

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DailyPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DailyWorkoutFragment()
            1 -> DailyNutritionFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }
} 