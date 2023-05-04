package com.ronivaldoroner.petshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.ronivaldoroner.petshop.R

class MainActivity : AppCompatActivity() {

    private val navHostFragment by lazy{
        supportFragmentManager.findFragmentById(R.id.nhMain) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navHostFragment.navController.setGraph(R.navigation.petshop_nav_graph, intent.extras)
    }
}
