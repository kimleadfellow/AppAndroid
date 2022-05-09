package com.example.leadfellow

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView

class AddProvidersPage : AppCompatActivity() {
    private var providerField : ScrollView? = null
    private var providerLayout : LinearLayout? = null
    private var addProviderButton : Button? = null
    private var leadInfoButton : Button? = null
    private var providerCount = 0
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_providerspage)
        providerLayout = findViewById(R.id.providerLayout)


    }
    fun onDelete(view: View){
        providerLayout!!.removeView(view.parent as View)
    }

    fun onAddField(view: View){
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView: View = inflater.inflate(R.layout.newprovider, null)
        providerLayout!!.addView(rowView, providerLayout!!.childCount - 1)
    }

    fun leadInfo(view: View){
        val intent = Intent(this, LeadInfoPage::class.java)
        startActivity(intent)
    }
}