package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBackground = findViewById<Button>(R.id.btnBackgroundTask)
        btnBackground.setOnClickListener {
            lifecycleScope.launch {
                execute()
            }
        }

    }

    private suspend fun execute() {
        withContext(Dispatchers.IO) {
            for(i in 1..100000) {
                Log.e("delay: ", "String: $i")
            }
            runOnUiThread {
                Toast.makeText(this@MainActivity, "Task Completed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

