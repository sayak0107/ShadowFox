package com.example.authguard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSignup: Button
    private lateinit var tvError: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

                etUsername = findViewById(R.id.etUsername)
                etEmail = findViewById(R.id.etEmail)
                etPassword = findViewById(R.id.etPassword)
                etConfirmPassword = findViewById(R.id.etConfirmPassword)
                btnSignup = findViewById(R.id.btnSignup)
                tvError = findViewById(R.id.tvError)

                btnSignup.setOnClickListener {
                    validateSignup()
                }
            }

            private fun validateSignup() {
                val username = etUsername.text.toString()
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()
                val confirmPassword = etConfirmPassword.text.toString()

                when {
                    username.isEmpty() -> {
                        etUsername.error = "Username is required"
                    }
                    email.isEmpty() -> {
                        etEmail.error = "Email is required"
                    }
                    password.isEmpty() -> {
                        etPassword.error = "Password is required"
                    }
                    confirmPassword.isEmpty() -> {
                        etConfirmPassword.error = "Confirm Password is required"
                    }
                    password != confirmPassword -> {
                        etConfirmPassword.error = "Passwords do not match"
                    }
                    else -> {
                        // Successful signup scenario, replace with your logic
                        Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()
                        tvError.visibility = TextView.GONE
                    }
                }
            }
    }

