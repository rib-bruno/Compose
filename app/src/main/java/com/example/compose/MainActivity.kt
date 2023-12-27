package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

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
                    // Greeting("Android")
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    //criando estado
    var clicks by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ClickCounter(clicks = clicks) {
            clicks++
        }
        HelloContent()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember {
            mutableStateOf("")
        }
        if (name.isNotEmpty()) {
            Text(
                text = "Hello, $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.headlineLarge
            )
        }
        //borda, etc
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
    }
}


@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "I've been clicked $clicks times.")
    }
}

data class Dog(
    val name: String,
    val breed: String
)

//Column  {
//    DogCard(dog = Dog("Maggie", "Vira-Lata"),
//        modifier = Modifier.background(Color.Green)
//    )
//    DogCard(dog = Dog("Dayse", "Vira-Lata"),
//        modifier = Modifier.background(Color.Blue)
//
//    )
//}
@Composable
fun DogCard(dog: Dog, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_dog),
            contentDescription = null,
            modifier = Modifier.size(72.dp)
            //deixar a imagem arredondada
            // .clip(CircleShape)

        )
        Column {
            Text(text = dog.name)
            Text(text = dog.breed)
        }

    }
}


@Composable
private fun TestingColumns() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
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
            Text(
                text = "Text 3",
                Modifier.padding(end = 30.dp)
            )

            Text(text = "Text 4")
        }

    }
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

//    Button(onClick = { /*TODO*/ },
//        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
//        Icon(
//            painter = painterResource(id = R.drawable.ic_star),
//            contentDescription = null,
//            tint = Color.Black
//        )
//        Text(text = "Confirmar",
//            color = Color.Black)
//    }

