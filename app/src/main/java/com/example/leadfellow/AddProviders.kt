package com.example.leadfellow

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.core.view.marginTop

class AddProviders : AppCompatActivity() {
    private var providerField : ScrollView? = null
    private var providerLayout : LinearLayout? = null
    private var addProviderButton : Button? = null
    private var providerCount = 0
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_providers)
        providerField = findViewById(R.id.providerField) as ScrollView

        providerField!!.setOnTouchListener(object : OnSwipeTouchListener(applicationContext){
            override fun onSwipeLeft(){
                swipeScreen()
            }
        })

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

    fun swipeScreen(){
        val intent = Intent(this, Leadinfo::class.java)
        startActivity(intent)
    }
}