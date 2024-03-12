package com.curiousapps.myrocket.data.repository

import com.curiousapps.myrocket.data.local.StockDatabase
import com.curiousapps.myrocket.data.mappers.toCompanyListing
import com.curiousapps.myrocket.data.remote.GameApi
import com.curiousapps.myrocket.domain.model.CompanyListing
import com.curiousapps.myrocket.domain.repository.StockRepository
import com.curiousapps.myrocket.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: GameApi,
    private val db: StockDatabase
): StockRepository  {

    private val dao = db.dao
    override suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListings(query)
            emit(Resource.Success(
                data = localListings.map { it.toCompanyListing() }
            ))

            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldLoadFromCache){
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListing = try {
                val response = api.getListings()
                //response.byteStream()
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("No Data to load"))
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("No Data to load"))
            }
        }
    }
}