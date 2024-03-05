package com.curiousapps.myrocket.data.remote

import android.util.Log
import com.curiousapps.myrocket.data.models.Games
import com.curiousapps.myrocket.data.models.Results
import com.curiousapps.myrocket.domain.Game
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GameApi {

    @GET("games")
    suspend fun getGames(
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("filter") name: String
    ): ResponseBody

    @GET("game/2/")
    suspend fun getGame(
//        @Header("guid") guid: Int,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,

    ): Games

    companion object{
        const val BASE_URL = "https://www.giantbomb.com/api/"
        const val FORMAT = "json"
        const val API_KEY = "9d45436f87d3848d2bdcce810bacb6df57dfd134"
    }
}
//
//val service = Retrofit.Builder()
//    .baseUrl(GameApi.BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//    .build()
//    .create(GameApi::class.java)
//
//CoroutineScope(Dispatchers.IO).launch {
//    val gameResponse = service.getGames(
//        apiKey = GameApi.API_KEY,
//        format = GameApi.FORMAT,
//        name = "BreakFree"
//    )
//
////                val imageResponse = service.getImage(
////                    apiKey = GameApi.API_KEY,
////                    format = GameApi.FORMAT,
////                    name = "Desert Strike: Return to the Gulf"
////                )
//
//    Log.e("From MainActivity", "onCreateGame: ${gameResponse.results}")
//    Log.i("Main", "Space")
//    Log.e("From MainActivity", "onCreateImage: ${gameResponse}")
//}