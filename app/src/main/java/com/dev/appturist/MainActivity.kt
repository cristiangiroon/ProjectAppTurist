package com.dev.appturist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//njhba
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nextButton: Button = findViewById(R.id.next_button)


        nextButton.setOnClickListener {
            val intent = Intent(this, ListPlacesActivity::class.java)
            startActivity(intent)
        }

    }


}