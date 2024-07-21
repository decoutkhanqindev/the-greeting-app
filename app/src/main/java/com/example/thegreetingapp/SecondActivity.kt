package com.example.thegreetingapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var nameReceiver: TextView
    private lateinit var languageReceiver: TextView
    private lateinit var imgReceiver: ImageView
    private lateinit var moveToGoogle: Button

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

        nameReceiver.text = intent.getStringExtra("name")
        languageReceiver.text = intent.getStringExtra("language")
        imgReceiver.setImageResource(intent.getIntExtra("img", 0))

        moveToGoogle.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(implicitIntent)
        }
    }
}