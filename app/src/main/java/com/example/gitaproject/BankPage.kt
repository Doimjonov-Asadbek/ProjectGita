package com.example.gitaproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BankPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_bank_page)
    }
}