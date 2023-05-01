package com.nexio.ventilo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nexio.ventilo.presentation.SignIn.SignInScreen

@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SignIn.route){
        composable(Screen.SignIn.route){
            SignInScreen(navController = navController)
        }
    }
}