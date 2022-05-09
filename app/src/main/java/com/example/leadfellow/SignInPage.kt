package com.example.leadfellow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class SignInPage : AppCompatActivity() {
    private var loginButton : Button? = null
    private var email: TextView? = null
    private var signup : TextView? = null
    private var loginPassword : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signinpage)
        loginButton = findViewById<View>(R.id.loginButton) as Button
        email = findViewById<View>(R.id.loginEmail) as TextView
        signup = findViewById<View>(R.id.loginSignUp) as TextView
        loginPassword = findViewById<View>(R.id.loginPassword) as EditText
        loginButton!!.setOnClickListener(){
            login()
        }
        signup!!.setOnClickListener(){
            signup()
        }
    }

    fun login(){
        val intent = Intent(this, AddProvidersPage::class.java)
        val pass: String? = loginPassword as? String
        if (pass != null) {
            Log.i(pass, "Krüpteerimata $pass")
        }
        val obj = BlowfishDemo()
        val cryptpass = obj.encrypt(loginPassword?.text.toString(), "key")
        Log.i(pass, "Krüpteeritud " + cryptpass)
        //print(obj.decrypt(loginPassword?.text.toString(), "key"))
        val url = "https://app.leadfellow.dev/api/login"
        // Post parameters
        // Form fields and values
        val params = HashMap<String,String>()
        params["email"] = email.toString()
        params["password_hash"] = cryptpass
        val jsonObject = JSONObject(params as Map<*, *>?)
        // Volley post request with parameters
        val request = JsonObjectRequest(Request.Method.POST,url,jsonObject,
            { response ->
                // Process the json
                try {
                    Log.i( "responsetag","Response: $response")
                }catch (e:Exception){
                    Log.i("exceptiontag","Exception: $e")
                }

            }, {
                // Error in request
                Log.i("errortag", "Volley error: $it")
            })
        // Volley request policy, only one time request to avoid duplicate transaction
        request.retryPolicy = DefaultRetryPolicy(
            DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
            // 0 means no retry
            0, // DefaultRetryPolicy.DEFAULT_MAX_RETRIES = 2
            1f // DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        // Add the volley post request to the request queue
        NetworkSingleton.getInstance(this).addToRequestQueue(request)
        startActivity(intent)
    }
    fun signup(){
        val intent = Intent(this, SignUpPage::class.java)
        startActivity(intent)
    }
    fun forgotPassword(){
        val intent = Intent(this, ForgotPasswordPage::class.java)
        startActivity(intent)
    }
}

