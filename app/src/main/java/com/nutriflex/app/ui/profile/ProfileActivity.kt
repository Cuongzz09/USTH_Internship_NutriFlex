package com.nutriflex.app.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nutriflex.app.R
import com.nutriflex.app.databinding.ActivityProfileBinding
import com.nutriflex.app.ui.auth.LoginActivity

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val phone = binding.etPhone.text.toString()
            val height = binding.etHeight.text.toString()
            val weight = binding.etWeight.text.toString()
            val age = binding.etAge.text.toString()

            if (validateInput(name, email, phone, height, weight, age)) {
                // TODO: Implement profile update logic
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        binding.btnLogout.setOnClickListener {
            // TODO: Implement logout logic
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun validateInput(name: String, email: String, phone: String, height: String, weight: String, age: String): Boolean {
        if (name.isEmpty()) {
            binding.etName.error = "Name is required"
            return false
        }
        if (email.isEmpty()) {
            binding.etEmail.error = "Email is required"
            return false
        }
        if (phone.isEmpty()) {
            binding.etPhone.error = "Phone number is required"
            return false
        }
        if (height.isEmpty()) {
            binding.etHeight.error = "Height is required"
            return false
        }
        if (weight.isEmpty()) {
            binding.etWeight.error = "Weight is required"
            return false
        }
        if (age.isEmpty()) {
            binding.etAge.error = "Age is required"
            return false
        }
        return true
    }
} 