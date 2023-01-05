package com.example.gitaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class RecoveryAccount : AppCompatActivity() {

    private var edtPhone:EditText? = null
    private var btnSend:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_recovery_account)

        edtPhone = findViewById(R.id.edtPhone)
        btnSend = findViewById(R.id.btnSend)

        edtPhone?.addTextChangedListener(loginTextWatcher)

        btnSend?.setOnClickListener {
            val phone = edtPhone?.text.toString()
            val intent = Intent(this, ConfirmationAccount::class.java)
            intent.putExtra("number", phone)
            startActivity(intent)
        }
    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val phone = edtPhone?.text.toString().trim()

            btnSend?.isEnabled = phone.isNotEmpty()

        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

}