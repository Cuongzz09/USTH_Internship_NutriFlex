package com.nutriflex.app.ui.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nutriflex.app.databinding.ItemOnboardingBinding
import com.nutriflex.app.model.OnboardingItem

class OnboardingAdapter(private val context: Context) :
    RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val items = listOf(
        OnboardingItem(
            title = context.getString(com.nutriflex.app.R.string.onboarding_body_info),
            description = context.getString(com.nutriflex.app.R.string.onboarding_gender),
            imageResId = com.nutriflex.app.R.drawable.ic_gender
        ),
        OnboardingItem(
            title = context.getString(com.nutriflex.app.R.string.onboarding_goal),
            description = context.getString(com.nutriflex.app.R.string.onboarding_motivation),
            imageResId = com.nutriflex.app.R.drawable.ic_goal
        ),
        OnboardingItem(
            title = context.getString(com.nutriflex.app.R.string.healthcare_title),
            description = context.getString(com.nutriflex.app.R.string.healthcare_issues),
            imageResId = com.nutriflex.app.R.drawable.ic_healthcare
        ),
        OnboardingItem(
            title = context.getString(com.nutriflex.app.R.string.fitness_title),
            description = context.getString(com.nutriflex.app.R.string.fitness_experience),
            imageResId = com.nutriflex.app.R.drawable.ic_fitness
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val binding = ItemOnboardingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OnboardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class OnboardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OnboardingItem) {
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description
            binding.ivImage.setImageResource(item.imageResId)
        }
    }
} 