package com.nexio.ventilo.presentation.navigation

import android.app.Activity.RESULT_OK
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyApp(){

}