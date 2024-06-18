package com.hakandindis.main.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


fun NavGraphBuilder.homeScreen(
    appBarTitle: String,
) {
    composable(
        route = "Home",
    ) {
        HomeRoute(appBarTitle = appBarTitle)
    }

}