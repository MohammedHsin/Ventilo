package com.nexio.ventilo
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.android.gms.auth.api.identity.Identity
import com.nexio.ventilo.presentation.SignIn.GoogleAuthUiClient
import com.nexio.ventilo.presentation.SignIn.SignInScreen
import com.nexio.ventilo.presentation.SignIn.SignInViewModel
import com.nexio.ventilo.presentation.navigation.Screen
import com.nexio.ventilo.presentation.onBoarding.OnBoarding
import com.nexio.ventilo.ui.theme.VentiloTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy{
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val bottomBarState = rememberSaveable { (mutableStateOf(false)) }
            VentiloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.OnBoarding.route){
                        composable(Screen.SignIn.route){

                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsState()

                            val launcher = rememberLauncherForActivityResult(contract =
                            ActivityResultContracts.StartIntentSenderForResult(), onResult = {
                                if(it.resultCode == RESULT_OK){
                                    lifecycleScope.launch {
                                        val signInResult = googleAuthUiClient.signInWithIntent(
                                            intent = it.data ?: return@launch
                                        )
                                        viewModel.onSignInResult(signInResult)
                                    }
                                }
                            }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful){
                                if(state.isSignInSuccessful){
                                    Toast.makeText(
                                        applicationContext,
                                        "got it !",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                            SignInScreen(navController = navController , state, onSignInClick = {
                                lifecycleScope.launch {
                                    val signInIntentSender = googleAuthUiClient.signIn()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            })
                        }




                        composable(Screen.OnBoarding.route){
                            OnBoarding(navController = navController)
                        }
                    }







                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VentiloTheme {
    }
}
