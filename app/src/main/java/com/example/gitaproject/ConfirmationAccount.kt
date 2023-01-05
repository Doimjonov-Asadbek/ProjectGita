package com.example.gitaproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.TextView

class ConfirmationAccount : AppCompatActivity() {

    private var phone:TextView? = null
    private var view1:TextView? = null
    private var view2:TextView? = null
    private var view3:TextView? = null
    private var view4:TextView? = null
    private var view5:TextView? = null
    private var view6:TextView? = null
    private var timer:TextView? = null
    private var confirm:Button? = null
    private var one:TextView? = null
    private var two:TextView? = null
    private var three:TextView? = null
    private var four:TextView? = null
    private var five:TextView? = null
    private var six:TextView? = null
    private var seven:TextView? = null
    private var eight:TextView? = null
    private var nine:TextView? = null
    private var zero:TextView? = null
    private var ok:TextView? = null
    private var space:TextView? = null
    private var delete:View? = null
    private var back:View? = null

    private var index = 0
    private var write = ""

    @SuppressLint("MissingInflatedId", "SetTextI18n", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_confirmation_account)

        val number = intent.getStringExtra("number").toString()
        phone = findViewById(R.id.phoneNumber)
        phone?.text = "+998$number"

        backTimer()

        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)
        view3 = findViewById(R.id.view3)
        view4 = findViewById(R.id.view4)
        view5 = findViewById(R.id.view5)
        view6 = findViewById(R.id.view6)

        one = findViewById(R.id.numberOne)
        two = findViewById(R.id.numberTwo)
        three = findViewById(R.id.numberThree)
        four = findViewById(R.id.numberFour)
        five = findViewById(R.id.numberFive)
        six = findViewById(R.id.numberSix)
        seven = findViewById(R.id.numberSeven)
        eight = findViewById(R.id.numberEight)
        nine = findViewById(R.id.numberNine)
        zero = findViewById(R.id.numberZero)

        confirm = findViewById(R.id.btnConfirm)
        ok = findViewById(R.id.buttonOK)
        space= findViewById(R.id.space)
        delete = findViewById(R.id.viewDelete)
        back = findViewById(R.id.back_ic)

        back?.setOnClickListener {
            onBackPressed()
        }

        timer = findViewById(R.id.timer)

        backTimer()
        view6?.addTextChangedListener(loginTextWatcher)

        confirm?.setOnClickListener{
            val intent = Intent(this@ConfirmationAccount, ChangePassword::class.java)
            startActivity(intent)
            finishAffinity()
        }

        one?.setOnClickListener {
            index++
            write = "1"
            click()
        }

        two?.setOnClickListener {
            index++
            write = "2"
            click()
        }

        three?.setOnClickListener {
            index++
            write = "3"
            click()
        }

        four?.setOnClickListener {
            index++
            write = "4"
            click()
        }

        five?.setOnClickListener {
            index++
            write = "5"
            click()
        }

        six?.setOnClickListener {
            index++
            write = "6"
            click()
        }

        seven?.setOnClickListener {
            index++
            write = "7"
            click()
        }

        eight?.setOnClickListener {
            index++
            write = "8"
            click()
        }

        nine?.setOnClickListener {
            index++
            write = "9"
            click()
        }

        zero?.setOnClickListener {
            index++
            write = "0"
            click()
        }

        delete?.setOnClickListener {
            index--
            backSpace()
        }

    }

    private fun click() {
        if (index > 6){
            index = 6
        }

        when(index){
            1 -> {
                view1?.text = write
            }
            2 -> {
                view2?.text = write
            }
            3 -> {
                view3?.text = write
            }
            4 -> {
                view4?.text = write
            }
            5 -> {
                view5?.text = write
            }
            6 -> {
                view6?.text = write
            }
        }
    }

    private fun backSpace() {
        if (index > 6) {
            index = 6
        }
        if (index < 0) {
            index = 0
        }
        when(index){
            1 -> {
                view1?.setBackgroundResource(R.drawable.corner)
                view1?.text = ""
            }
            2 -> {
                view2?.setBackgroundResource(R.drawable.corner)
                view2?.text = ""
            }
            3 -> {
                view3?.setBackgroundResource(R.drawable.corner)
                view3?.text = ""
            }
            4 -> {
                view4?.setBackgroundResource(R.drawable.corner)
                view4?.text = ""
            }
            5 -> {
                view5?.setBackgroundResource(R.drawable.corner)
                view5?.text = ""
            }
            6 -> {
                view6?.setBackgroundResource(R.drawable.corner)
                view6?.text = ""
            }
        }

    }

    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val view6 = view6?.text.toString().trim()

            confirm?.isEnabled = view6.isNotEmpty()

        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

    private fun backTimer() {
        object : CountDownTimer(59000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                timer?.text = "00:" + millisUntilFinished / 1000
            }

            @SuppressLint("SetTextI18n", "ResourceAsColor")
            override fun onFinish() {
                timer?.text = "Resend code"
                timer?.setTextColor(R.color.red)
            }
        }
    }

}


