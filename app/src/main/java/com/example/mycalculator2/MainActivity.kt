package com.example.mycalculator2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mycalculator2.ui.theme.MyCalculator2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCalculator2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(this)
                    //Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}

@Composable
fun Greeting(context: Context) {

    var num1 = remember { mutableStateOf("")}

    var num2 = remember { mutableStateOf("")}
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(
            value = num1.value,
            onValueChange = {
                num1.value = it;
            }
        )

        TextField(
            value = num2.value,
            onValueChange = {
                num2.value = it;
            }
        )

        Button(onClick = {
            var result = num1.value.toInt() + num2.value.toInt()
            Toast.makeText(context,"Hello $result",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Add")
        }

        Button(onClick = {
            var result = num1.value.toInt() - num2.value.toInt()
            Toast.makeText(context,"Hello $result",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Subtract")
        }

        Button(onClick = {
            var result = num1.value.toInt() * num2.value.toInt()
            Toast.makeText(context,"Hello $result",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Multiply")
        }

        Button(onClick = {
            var result = num1.value.toInt() / num2.value.toInt()
            Toast.makeText(context,"Hello $result",Toast.LENGTH_LONG).show()
        }) {
            Text(text = "Divide")
        }


    }

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyCalculator2Theme {
//        Greeting()
//    }
//}