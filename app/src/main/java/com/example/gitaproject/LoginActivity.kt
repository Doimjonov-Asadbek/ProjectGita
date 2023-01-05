package com.example.gitaproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    private var number: EditText? = null
    private var password: EditText? = null
    private var txtRegister: TextView? = null
    private var login: Button? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)

        number = findViewById(R.id.edtNumber)
        password = findViewById(R.id.edtPass)
        login = findViewById(R.id.btnLogin)
        txtRegister = findViewById(R.id.goToRegistration)

        txtRegister?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        login?.setOnClickListener {
            val intent = Intent(this, RecoveryAccount::class.java)
            startActivity(intent)
            finish()
        }

        number?.addTextChangedListener(loginTextWatcher)
        password?.addTextChangedListener(loginTextWatcher)

    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val number = number?.text.toString().trim()
            val password = password?.text.toString().trim()

            login?.isEnabled = number.isNotEmpty() && password.isNotEmpty()

        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

}









