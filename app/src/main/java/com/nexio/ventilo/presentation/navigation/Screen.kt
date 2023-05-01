package com.nexio.ventilo.presentation.navigation

sealed class Screen(val route : String){
    object SignIn : Screen("sign_in")
}
