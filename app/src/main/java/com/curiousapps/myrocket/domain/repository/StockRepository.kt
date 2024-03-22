package com.curiousapps.myrocket.domain.repository

import com.curiousapps.myrocket.domain.model.CompanyInfo
import com.curiousapps.myrocket.domain.model.CompanyListing
import com.curiousapps.myrocket.domain.model.IntradayInfo
import com.curiousapps.myrocket.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>


    suspend fun getIntradayInfo(
        symbol: String
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String
    ): Resource<CompanyInfo>
}