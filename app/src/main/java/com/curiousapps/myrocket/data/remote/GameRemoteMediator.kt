package com.curiousapps.myrocket.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.curiousapps.myrocket.data.local.GameDatabase
import com.curiousapps.myrocket.data.local.GameEntity
import com.curiousapps.myrocket.data.mappers.toGameEntity
import okio.IOException
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class GameRemoteMediator(
    private val gameDb: GameDatabase,
    private val gameApi: GameApi
): RemoteMediator<Int, GameEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GameEntity>
    ): MediatorResult {
        return try {

            val loadKey = when(loadType){
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )
                LoadType.APPEND -> 1
            }

            val games = gameApi.getGames(
                apiKey = GameApi.API_KEY,
                format = GameApi.FORMAT,
                name = ""
            )
            gameDb.withTransaction {
                if (loadType == LoadType.REFRESH){
                    //gameDb.dao.clearAll()
                }
                val gameEntities = games.map { it.toGameEntity() }
                //gameDb.dao.upsertAll(results = gameEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = true
            )

        }catch (e: IOException){
            MediatorResult.Error(e)
        }catch (e: HttpException){
            MediatorResult.Error(e)
        }
    }

}