package com.rmarenco.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        //val fragment = CounterFragment()
        val fragment = DataFragment.newInstance("Roberto", "Marenco")
        fragmentManager.beginTransaction()
            .replace(R.id.counter_dinamy_fragment, fragment)
            .add(R.id.counter_dinamy_fragment,DataFragment.newInstance("Test","Test"))
            .commit()
    }
}