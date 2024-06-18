package com.hakandindis.weatherapp.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.hakandindis.main.home.homeScreen


@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "Home",
        modifier = Modifier
    ) {
        homeScreen(
            appBarTitle = "Home"
        )
    }

}