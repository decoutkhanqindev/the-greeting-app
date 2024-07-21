package com.example.thegreetingapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    lateinit var nameReceiver: TextView
    lateinit var languageReceiver: TextView
    lateinit var imgReceiver: ImageView
    lateinit var moveToGoogle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameReceiver = findViewById(R.id.nameReceiver)
        languageReceiver = findViewById(R.id.languageReceiver)
        imgReceiver = findViewById(R.id.imgReceiver)
        moveToGoogle = findViewById(R.id.moveToGoogle)
    }
}