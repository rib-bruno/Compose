package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListScreen()
                }
            }
        }
    }
}

data class Person(
    val name: String
)

@Composable
fun ListScreen() {
    val personList = listOf(Person("Bruno"), Person("João"), Person("Rejane"), Person("Maggie"))

    LazyColumn (
      //  modifier = Modifier.background(Color.Magenta),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical =  50.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        //horizontal só se for numa Row
    ) {
        items(personList) {
           ItemList(name = it.name) 
        }
    }

}

@Composable
fun ItemList(name: String) {
    Text(text = name,
       // modifier = Modifier.background(Color.Green)
    )
}
