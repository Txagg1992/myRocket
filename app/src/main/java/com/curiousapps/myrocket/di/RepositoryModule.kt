package com.curiousapps.myrocket.di

import com.curiousapps.myrocket.data.csv.CSVParser
import com.curiousapps.myrocket.data.csv.CompanyListingsParser
import com.curiousapps.myrocket.data.repository.StockRepositoryImpl
import com.curiousapps.myrocket.domain.model.CompanyListing
import com.curiousapps.myrocket.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepository: StockRepositoryImpl
    ): StockRepository
}