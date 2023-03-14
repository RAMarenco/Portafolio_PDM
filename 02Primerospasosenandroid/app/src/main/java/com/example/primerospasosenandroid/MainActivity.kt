package com.example.primerospasosenandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var mEmailEditText: EditText
    private lateinit var mMessageEditText: EditText
    private lateinit var mSendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()

        mSendButton.setOnClickListener {
            val intent = Intent(this@MainActivity, MessageSentActivity::class.java)
            startActivity(intent)
        }
    }

    fun bind() {
        mSendButton = findViewById(R.id.action_send)
    }
}