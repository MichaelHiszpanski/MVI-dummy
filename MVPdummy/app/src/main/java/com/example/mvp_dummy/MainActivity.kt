package com.example.mvp_dummy

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.multidex.MultiDex
import com.example.mvp_dummy.analiticsHelper.AnalyticsHelper
import com.example.mvp_dummy.gpt.MainScreen
import com.example.mvp_dummy.presenters.LoginPresenter
import com.example.mvp_dummy.ui.components.LoginForm
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var presenter: LoginPresenter

    @Inject
    lateinit var analyticsHelper: AnalyticsHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        presenter = LoginPresenter(this)
        analyticsHelper.logScreenTransition("LoginScreen", "HomeScreen")
        setContent {
//            LoginScreen(onLoginClicked = { username, password ->
//                presenter.onLoginClicked(username, password)
//            })
            MainScreen()
        }

        fun showLoginSuccess() {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
        }

        fun showLoginError() {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}



interface LoginView {
    fun navigateToHome()
    fun showLoginError()
    fun showValidationError(error: String)
}

//@AndroidEntryPoint
//class MainActivity : ComponentActivity(), LoginView {
//
//    private lateinit var presenter: LoginPresenter
//    @Inject
//    lateinit var analyticsHelper: AnalyticsHelper
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        presenter = LoginPresenter(this)
//
//        setContent {
////            LoginScreen(onLoginClicked = { username, password ->
////                presenter.onLoginClicked(username, password)
////            })
//            MainScreen(analyticsHelper)
//        }
//    }

//    @Composable
//    fun LoginScreen(onLoginClicked: (String, String) -> Unit) {
//        LoginForm(onLoginClicked = onLoginClicked)
//    }
//
//    override fun navigateToHome() {
//        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
//        // Navigate to home screen
//    }
//
//    override fun showLoginError() {
//        Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun showValidationError(error: String) {
//        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onDestroy() {
//        presenter.onDestroy()
//        super.onDestroy()
//    }
//}
//@Composable
//fun MyApp(presenter: LoginPresenterOld) {
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    Column(modifier = Modifier.padding(16.dp)) {
//        TextField(
//            value = username,
//            onValueChange = { username = it },
//            label = { Text("Username") }
//        )
//        TextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            visualTransformation = PasswordVisualTransformation()
//        )
//        Button(onClick = { presenter.onLoginClicked(username, password) }) {
//            Text("Log in")
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}