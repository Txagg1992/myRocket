package com.curiousapps.myrocket.data.mappers

import com.curiousapps.myrocket.data.remote.dto.IntraDayInfoDto
import com.curiousapps.myrocket.domain.model.IntradayInfo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun IntraDayInfoDto.toIntradayInfo(): IntradayInfo{
    val pattern = "yyyy-MM-dd HH:mm:ss"
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
    val localDateTime = LocalDateTime.parse(timeStamp, formatter)
    return IntradayInfo(
        date = localDateTime,
        close = close
    )
}

fun IntradayInfo.toIntradayInfoDto(): IntraDayInfoDto{


    return IntraDayInfoDto(
        timeStamp = "",
        close = close
    )
}