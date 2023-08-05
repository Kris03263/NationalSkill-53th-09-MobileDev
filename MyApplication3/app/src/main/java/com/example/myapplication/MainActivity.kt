package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val NavHost = findNavController(R.id.fragmentContainerView)
        val AppBarConfiguration = AppBarConfiguration.Builder(btnNav.menu).build()
        NavigationUI.setupActionBarWithNavController(this,NavHost,AppBarConfiguration)
        NavigationUI.setupWithNavController(btnNav,NavHost)
    }

    override fun onSupportNavigateUp(): Boolean {
        var navHost = findNavController(R.id.fragmentContainerView)
        return navHost.navigateUp()
    }
}