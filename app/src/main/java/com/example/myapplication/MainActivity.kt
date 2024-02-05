package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    login()
                }
            }
        }
    }
}

@Composable
fun login() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.top_background),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.height(150.dp),
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .padding(bottom = 16.dp),
            label = { Text(text = "Username") },
            shape = RoundedCornerShape(50),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = colorResource(R.color.purple),
                focusedIndicatorColor = colorResource(R.color.purple),
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .padding(bottom = 16.dp),
            label = { Text(text = "Password") },
            shape = RoundedCornerShape(50),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = colorResource(R.color.purple),
                focusedIndicatorColor = colorResource(R.color.purple),
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
            )
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 54.dp), onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.purple)
            )
        ) {
            Text(text = "Login", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(text = "Forgot Password  ")
            Text(text = "click here!", modifier = Modifier
                .clickable { println("şifre değiştrilidi") })
        }
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = null,
                Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = null,
                Modifier.padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = null,
                Modifier.padding(8.dp)
            )

        }
        Image(
         // modifier =  Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.bottom_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )


    }
}

@Preview(showBackground = true)
@Composable
fun PrevLogin() {
    login()
}