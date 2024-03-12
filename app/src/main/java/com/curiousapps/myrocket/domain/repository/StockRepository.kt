package com.curiousapps.myrocket.domain.repository

import com.curiousapps.myrocket.domain.model.CompanyListing
import com.curiousapps.myrocket.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

}