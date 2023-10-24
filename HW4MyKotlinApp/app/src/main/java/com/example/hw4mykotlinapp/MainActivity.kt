package com.example.hw4mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val switch = findViewById<Switch>(R.id.switch1)
        val textView = findViewById<TextView>(R.id.textview_message)

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textView.text = resources.getString(R.string.switch_checked_text)
            } else {
                textView.text =resources.getString(R.string.switch_unchecked_text)
            }
        }
    }
}