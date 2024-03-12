package com.curiousapps.myrocket.data.remote

import com.curiousapps.myrocket.data.models.Games
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("games")
    suspend fun getGames(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String,
        @Query("filter") name: String
    ): ResponseBody

    @GET("game/2/")
    suspend fun getGame(
//        @Header("guid") guid: Int,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,

    ): Games

    @GET("query?function=LISTING_STATUS")
    suspend fun getListings(
        @Query("apikey") apiKey: String = S_API_KEY
    ): ResponseBody

    companion object{
        const val BASE_URL = "https://www.giantbomb.com/api/"
        const val FORMAT = "json"
        const val API_KEY = "9d45436f87d3848d2bdcce810bacb6df57dfd134"
        const val S_API_KEY = "5QDAW4RPYUR4JRQF"
        const val S_BASE_URL = "https://www.alphavantage.co/"
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