package com.example.leadfellow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Leadinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leadinfo)
    }
    fun login(view: View){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }
}