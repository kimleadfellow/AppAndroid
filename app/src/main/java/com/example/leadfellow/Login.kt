package com.example.leadfellow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import kotlin.math.sign
import com.example.leadfellow.BlowfishDemo

class Login : AppCompatActivity() {
    private var loginButton : Button? = null
    private var signup : TextView? = null
    private var loginPassword : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton = findViewById<View>(R.id.loginButton) as Button
        signup = findViewById<View>(R.id.loginSignUp) as TextView
        loginPassword = findViewById(R.id.loginPassword) as EditText
        loginButton!!.setOnClickListener(){
            login()
        }
        signup!!.setOnClickListener(){
            signup()
        }
    }
    fun login(){
        val intent = Intent(this, AddProviders::class.java)
        print(loginPassword)
        val obj = BlowfishDemo()
        print(obj.encrypt(loginPassword?.text.toString(), "key"))
        print(obj.decrypt(loginPassword?.text.toString(), "key"))
        startActivity(intent)
    }
    fun signup(){
        val intent = Intent(this, Signup::class.java)
        startActivity(intent)
    }
    fun forgotPassword(view: View){
        val intent = Intent(this, ForgotPassword::class.java)
        startActivity(intent)
    }
}

