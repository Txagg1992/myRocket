package com.curiousapps.myrocket.data.remote

import com.curiousapps.myrocket.data.models.Games
import com.curiousapps.myrocket.data.models.Results
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("games")
    suspend fun getGames(
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("filter") name: String
    ): List<Results>

    companion object{
        const val BASE_URL = "https://www.giantbomb.com/api/"
        const val FORMAT = "json"
        const val API_KEY = "9d45436f87d3848d2bdcce810bacb6df57dfd134"
    }
}