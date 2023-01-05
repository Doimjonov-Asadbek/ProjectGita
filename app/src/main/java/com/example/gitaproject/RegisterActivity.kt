package com.example.gitaproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

@Suppress("DEPRECATION")
class RegisterActivity : AppCompatActivity() {

    private var firstName: EditText? = null
    private var lastName: EditText? = null
    private var phoneNumber: EditText? = null
    private var password: TextInputEditText? = null
    private var register: Button? = null
    private var goToLogin: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_register)

        firstName = findViewById(R.id.edtFirstName)
        lastName= findViewById(R.id.edtLastName)
        phoneNumber = findViewById(R.id.edtPhoneNumber)
        password = findViewById(R.id.edtPassword)
        register = findViewById(R.id.btnRegister)
        goToLogin = findViewById(R.id.goToLogin)

        goToLogin?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        register?.setOnClickListener{
            val intent = Intent(this, RecoveryAccount::class.java)
            startActivity(intent)
            finishAffinity()
        }

        firstName?.addTextChangedListener(loginTextWatcher)
        lastName?.addTextChangedListener(loginTextWatcher)
        phoneNumber?.addTextChangedListener(loginTextWatcher)
        password?.addTextChangedListener(loginTextWatcher)

    }

    private val loginTextWatcher = object : TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val firstName = firstName?.text.toString().trim()
            val lastName = lastName?.text.toString().trim()
            val phoneNumber = phoneNumber?.text.toString().trim()
            val password = password?.text.toString().trim()

            register?.isEnabled = firstName.isNotEmpty() && lastName.isNotEmpty() && phoneNumber.isNotEmpty() && password.isNotEmpty()

        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

}