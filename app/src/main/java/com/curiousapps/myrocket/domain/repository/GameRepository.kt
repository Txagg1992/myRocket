package com.curiousapps.myrocket.domain.repository

import androidx.room.Query
import com.curiousapps.myrocket.domain.model.Game
import com.curiousapps.myrocket.util.Resource
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun getGameList(

        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<Game>>>
}