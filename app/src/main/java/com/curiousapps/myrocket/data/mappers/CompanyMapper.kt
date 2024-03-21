package com.curiousapps.myrocket.data.mappers

import com.curiousapps.myrocket.data.local.CompanyListingEntity
import com.curiousapps.myrocket.data.remote.dto.CompanyInfoDto
import com.curiousapps.myrocket.domain.model.CompanyInfo
import com.curiousapps.myrocket.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing{
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity{
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {


    return CompanyInfo(
        symbol = symbol ?:"",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}