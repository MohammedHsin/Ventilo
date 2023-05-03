package com.nexio.ventilo.presentation.SignIn

data class SignInState(
    val isSignInSuccessful : Boolean = false,
    val signInErrorMessage : String? = null
)
