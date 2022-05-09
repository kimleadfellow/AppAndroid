package com.example.leadfellow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

class LeadInfoPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leadinfopage)
    }
    fun sendLead(view: View, leadinfo: LeadInfo){
        val intent = Intent(this, SignInPage::class.java)
        val url = "https://app.leadfellow.dev/api/login"
        // Post parameters
        // Form fields and values
        val params = HashMap<String,String?>()
        params["token"] = leadinfo.token
        params["company"] = leadinfo.company
        params["person_first"] = leadinfo.person_first
        params["person_last"] = leadinfo.person_last
        params["phone"] = leadinfo.phone
        params["phone_area_code"] = leadinfo.phone_area_code
        params["email"] = leadinfo.email
        params["info"] = leadinfo.info
        params["commission"] = leadinfo.commission
        params["provider_emails"] = leadinfo.provider_emails.toString()
        val jsonObject = JSONObject(params as Map<*, *>?)
        // Volley post request with parameters
        val request = JsonObjectRequest(
            Request.Method.POST,url,jsonObject,
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
        startActivity(intent)
    }
}