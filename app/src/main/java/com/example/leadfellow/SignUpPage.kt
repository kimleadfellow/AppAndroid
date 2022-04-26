package com.example.leadfellow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SignUpPage : AppCompatActivity() {
    private var signupButton: Button?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signuppage)
        signupButton = findViewById<View>(R.id.forgotPassButton) as Button
        signupButton!!.setOnClickListener(){

        }
    }
    fun goBack(view: View){
        val intent= Intent(this, SignInPage::class.java)
        startActivity(intent)
    }
    fun signup(){
        //Lisada registreerimine andmebaasiga
        val intent= Intent(this, SignInPage::class.java)
        startActivity(intent)
    }
}