package com.example.thegreetingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputName: EditText
    private lateinit var inputLanguage: EditText
    private lateinit var btn: Button
    private lateinit var imgLanguage: ImageView
    private lateinit var moveToSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputName = findViewById(R.id.inputName)
        inputLanguage = findViewById(R.id.inputLanguage)
        btn = findViewById(R.id.btn)
        imgLanguage = findViewById(R.id.languageImg)
        moveToSecondActivity = findViewById(R.id.moveToSecondActivity)

        btn.setOnClickListener {
            Toast.makeText(this, "Hello ${inputName.text}", Toast.LENGTH_LONG).show()

            var imgResourceId = when (inputLanguage.text.toString().lowercase()) {
                "java" -> R.drawable.java
                "kotlin" -> R.drawable.kotln
                else -> R.drawable.ic_launcher_foreground
            }
            imgLanguage.setImageResource(imgResourceId)
            imgLanguage.setTag(imgResourceId)
        }

        moveToSecondActivity.setOnClickListener {
            val explicitIntent = Intent(this, SecondActivity::class.java)
            explicitIntent.putExtra("name", inputName.text.toString())
            explicitIntent.putExtra("language", inputLanguage.text.toString())
            explicitIntent.putExtra("img", imgLanguage.tag as? Int)
            startActivity(explicitIntent)
        }
    }
}