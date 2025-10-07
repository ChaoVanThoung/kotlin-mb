package com.example.mb_scanthub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mb_scanthub.ui.theme.MbscanthubTheme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.mb_scanthub.ui.LoginScreen
import com.example.mb_scanthub.ui.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MbscanthubTheme {
                var showHome by remember { mutableStateOf(false) }

                if (showHome) {
                    MyApp()
                } else {
                    LoginScreen(onLoginClick = { showHome = true })
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MbscanthubTheme {
        LoginScreen()
    }
}