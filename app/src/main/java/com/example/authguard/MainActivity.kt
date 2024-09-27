package com.example.authguard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvError: TextView
    private lateinit var btnSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvError = findViewById(R.id.tvError)
        btnSignup = findViewById(R.id.btnSignup)

        btnLogin.setOnClickListener {
            validateLogin()
        }

        btnSignup.setOnClickListener {
            // Navigate to SignupActivity when the Sign Up button is clicked
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateLogin() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()

        when {
            username.isEmpty() -> {
                etUsername.error = "Username is required"
            }
            password.isEmpty() -> {
                etPassword.error = "Password is required"
            }
            username == "Sayak" && password == "123456" -> {
                // Successful login scenario, navigate to WelcomeActivity
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
                finish()  // Finish LoginActivity so it's removed from the back stack
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                tvError.visibility = TextView.GONE
            }
            else -> {
                // Error handling
                tvError.text = "Invalid username or password"
                tvError.visibility = TextView.VISIBLE
            }
        }
    }
}
//final

























//package com.example.authguard
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var etUsername: EditText
//    private lateinit var etPassword: EditText
//    private lateinit var btnLogin: Button
//    private lateinit var tvError: TextView
//    private lateinit var btnSignup: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        etUsername = findViewById(R.id.etUsername)
//        etPassword = findViewById(R.id.etPassword)
//        btnLogin = findViewById(R.id.btnLogin)
//        tvError = findViewById(R.id.tvError)
//        btnSignup = findViewById<Button>(R.id.btnSignup)
//
//        btnLogin.setOnClickListener {
//            validateLogin()
//        }
//    }
//
//        private fun validateLogin() {
//            val username = etUsername.text.toString()
//            val password = etPassword.text.toString()
//
//            when {
//                username.isEmpty() -> {
//                    etUsername.error = "Username is required"
//                }
//                password.isEmpty() -> {
//                    etPassword.error = "Password is required"
//                }
//                username == "Sayak" && password == "123456" -> {
//                    // Successful login scenario, navigate to WelcomeActivity
//                    val intent = Intent(this, WelcomeActivity::class.java)
//                    startActivity(intent)
//                    finish()  // Finish LoginActivity so it's removed from the back stack
//                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
//                    tvError.visibility = TextView.GONE
//                }
//                else -> {
//                    // Error handling
//                    tvError.text = "Invalid username or password"
//                    tvError.visibility = TextView.VISIBLE
//                }
//            }
//
//        btnSignup.setOnClickListener {
//            val intent = Intent(this, SignupActivity::class.java)
//            startActivity(intent)
//        }
//    }
//}
