package com.nexio.ventilo.presentation.navigation

sealed class Screen(val route : String){
    object SignIn : Screen("sign_in")
    object OnBoarding : Screen("on_boarding")
}
