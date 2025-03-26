package ru.devakaemov.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_menu).setOnClickListener {
            Toast.makeText(this, "МЕНЮ", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button_favorites).setOnClickListener {
            Toast.makeText(this, "ИЗБРАННОЕ", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button_watch_later).setOnClickListener {
            Toast.makeText(this, "ПОСМОТРЕТЬ ПОЗЖЕ", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button_collection).setOnClickListener {
            Toast.makeText(this, "ПОДБОРКИ", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.button_settings).setOnClickListener {
            Toast.makeText(this, "НАСТРОЙКИ", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}