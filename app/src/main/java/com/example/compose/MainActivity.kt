package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    MainScreen()
                }
            }
        }
    }
}


@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()) {
        Text(
            text = "Hello world!!", maxLines = 3,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .background(Color.Green)
                .fillMaxWidth()
        )
        Text(
            text = "Outro texto qualquer!",
            maxLines = 3,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth()
        )
        
        Row {
            Text(text = "Text 3",
                Modifier.padding(end = 30.dp)
                )

            Text(text = "Text 4")
        }
        
    }

//    Button(onClick = { /*TODO*/ },
//        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
//
//        Icon(
//            painter = painterResource(id = R.drawable.ic_star),
//            contentDescription = null,
//            tint = Color.Black
//        )
//        Text(text = "Confirmar",
//            color = Color.Black)
//    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTheme {
        Greeting("Bruno")
    }
}