package com.nexio.ventilo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.nexio.ventilo.presentation.SignIn.SignInScreen
import com.nexio.ventilo.presentation.SignIn.SignInViewModel
import com.nexio.ventilo.presentation.onBoarding.OnBoarding

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun MyApp(){
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = Screen.OnBoarding.route){
//        composable(Screen.SignIn.route){
//            val viewModel = viewModel<SignInViewModel>()
//            val state = viewModel.state.collectAsState()
//            SignInScreen(navController = navController)
//        }
//
//        composable(Screen.OnBoarding.route){
//            OnBoarding(navController = navController)
//        }
//    }
//}