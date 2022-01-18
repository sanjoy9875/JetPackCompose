package com.example.jetpackwithmvvm

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.R.attr.fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val recipeFragment = RecipeFragment()
        fragmentTransaction.add(R.id.flContainer,recipeFragment,"RecipeFragment")
        fragmentTransaction.commit()
    }
}