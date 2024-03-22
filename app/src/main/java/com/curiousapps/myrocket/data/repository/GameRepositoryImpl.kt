package com.curiousapps.myrocket.data.repository

import com.curiousapps.myrocket.data.local.GameDatabase
import com.curiousapps.myrocket.data.remote.GameApi
import com.curiousapps.myrocket.domain.model.Game
import com.curiousapps.myrocket.domain.repository.GameRepository
import com.curiousapps.myrocket.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameRepositoryImpl @Inject constructor(
    val api: GameApi,
    private val db: GameDatabase
): GameRepository{

    private val dao = db.dao
    override suspend fun getGameList(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<Game>>> {
        TODO("Not yet implemented")
    }
//    override suspend fun getGameList(
//        fetchFromRemote: Boolean,
//        query: String
//    ): Flow<Resource<List<Game>>> {
//        return flow {
//            emit(Resource.Loading(true))
//            val localGames = dao.searchGames(query)
//            emit(Resource.Success(
//                data = localGames.map { it.toGame() }
//            ))
//
//            val isDbEmpty = localGames.isEmpty() && query.isBlank()
//            val shouldLoadFromCache = !isDbEmpty && !fetchFromRemote
//            if (shouldLoadFromCache){
//                emit(Resource.Loading(false))
//                return@flow
//            }
//
//            val remoteListing = try {
//                val response = api.getGames(GameApi.API_KEY, GameApi.FORMAT, "")
//                response.byteStream()
//            }catch (e: IOException){
//                e.printStackTrace()
//                emit(Resource.Error("Couldn't load from DB"))
//            }catch (e: HttpException){
//                e.printStackTrace()
//                emit(Resource.Error("Couldn't load from API"))
//            }
//
//        }
//    }
}