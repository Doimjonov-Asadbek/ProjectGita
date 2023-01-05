package com.example.gitaproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class ChangePassword : AppCompatActivity() {

    private var save: Button? = null
    private var newPassword: EditText? = null
    private var changePassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_change_password)

        save = findViewById(R.id.btnSavePassword)
        newPassword = findViewById(R.id.edtNewPassword)
        changePassword = findViewById(R.id.edtChangePassword)

        newPassword?.addTextChangedListener(loginTextWatcher)
        changePassword?.addTextChangedListener(loginTextWatcher)

        save?.setOnClickListener {

            if (newPassword?.text.toString().isEmpty() && changePassword?.text.toString().isEmpty()){
                newPassword?.error = "Enter password"
                changePassword?.error = "Enter password"
            }
            else if (newPassword?.text.toString().isEmpty()){
                newPassword?.error = "Enter password"
            }
            else if (changePassword?.text.toString().isEmpty()){
                changePassword?.error = "Enter password"
            }
            else if (newPassword?.text.toString() != changePassword?.text.toString()){
                newPassword?.error = "Passwords must match"
                changePassword?.error = "Passwords must match"
            }
            else{
                val intent = Intent(this, PasscodePage::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }
    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val newPassword = newPassword?.text.toString().trim()
            val changePassword = changePassword?.text.toString().trim()

            save?.isEnabled = newPassword.isNotEmpty() && changePassword.isNotEmpty()

        }

        override fun afterTextChanged(s: Editable?) {
        }

    }
}