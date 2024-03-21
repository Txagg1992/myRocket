package com.curiousapps.myrocket.data.repository

import androidx.compose.ui.text.resolveDefaults
import com.curiousapps.myrocket.data.csv.CSVParser
import com.curiousapps.myrocket.data.csv.IntradayInfoParser
import com.curiousapps.myrocket.data.local.StockDatabase
import com.curiousapps.myrocket.data.mappers.toCompanyInfo
import com.curiousapps.myrocket.data.mappers.toCompanyListing
import com.curiousapps.myrocket.data.mappers.toCompanyListingEntity
import com.curiousapps.myrocket.data.remote.GameApi
import com.curiousapps.myrocket.domain.model.CompanyInfo
import com.curiousapps.myrocket.domain.model.CompanyListing
import com.curiousapps.myrocket.domain.model.IntradayInfo
import com.curiousapps.myrocket.domain.repository.StockRepository
import com.curiousapps.myrocket.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.io.PrintStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockRepositoryImpl @Inject constructor(
    private val api: GameApi,
    private val db: StockDatabase,
    private val companyListingsParser: CSVParser<CompanyListing>,
    private val intradayInfoParser: CSVParser<IntradayInfo>
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
                companyListingsParser.parse(response.byteStream())
            }catch (e: IOException){
                e.printStackTrace()
                emit(Resource.Error("No Data to load"))
                null
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Resource.Error("No Data to load"))
                null
            }

            remoteListing?.let { listings ->
                dao.clearCompanyListings()
                dao.insertCompanyListing(
                    listings.map {
                        it.toCompanyListingEntity()
                    }
                )
                emit(Resource.Success(
                    data = dao
                        .searchCompanyListings("")
                        .map { it.toCompanyListing() }
                ))
                emit(Resource.Loading(false))

            }
        }
    }

    override suspend fun getIntradayInfo(symbol: String): Resource<List<IntradayInfo>> {
        return try {
            val response = api.getIntradayInfo(symbol)
            val results = intradayInfoParser.parse(response.byteStream())
            Resource.Success(results)
        }catch (e: IOException){
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load intraday info"
            )
        }catch (e: HttpException){
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load intraday info"
            )
        }
    }

    override suspend fun getCompanyInfo(symbol: String): Resource<CompanyInfo> {
        return try {
            val result = api.getCompanyInfo(symbol)
            Resource.Success(result.toCompanyInfo())
        }catch (e: IOException){
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load company info"
            )
        }catch (e: HttpException){
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load company info"
            )
        }
    }


}