package com.example.primerospasosenandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView

class MessageSentActivity : AppCompatActivity() {
    lateinit var mTimerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_sent)
        bind()

        object : CountDownTimer(4000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimerTextView.text = getString(R.string.seconds_to_redirect_text, (millisUntilFinished/1000))
            }

            override fun onFinish() {
                val intent = Intent(this@MessageSentActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }.start()
    }

    fun bind () {
        mTimerTextView = findViewById(R.id.timer_text_view)
    }




}