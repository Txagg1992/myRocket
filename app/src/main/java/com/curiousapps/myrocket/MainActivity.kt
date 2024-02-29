package com.curiousapps.myrocket

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.curiousapps.myrocket.data.remote.GameApi
import com.curiousapps.myrocket.ui.theme.MyRocketTheme
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = Retrofit.Builder()
            .baseUrl(GameApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(GameApi::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val gameResponse = service.getGames(
                apiKey = GameApi.API_KEY,
                format = GameApi.FORMAT,
                name = "BreakFree"
            )

//                val imageResponse = service.getImage(
//                    apiKey = GameApi.API_KEY,
//                    format = GameApi.FORMAT,
//                    name = "Desert Strike: Return to the Gulf"
//                )

             Log.e("From MainActivity", "onCreateGame: ${gameResponse.results}")
            Log.i("Main", "Space")
            Log.e("From MainActivity", "onCreateImage: ${gameResponse}")
        }
        setContent {

            MyRocketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("MyRocket")
                }
            }
        }
    }
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
    MyRocketTheme {
        Greeting("Android")
    }
}