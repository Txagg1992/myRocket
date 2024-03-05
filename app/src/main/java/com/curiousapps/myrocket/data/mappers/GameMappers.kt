package com.curiousapps.myrocket.data.mappers

import com.curiousapps.myrocket.data.local.GameEntity
import com.curiousapps.myrocket.data.models.Image
import com.curiousapps.myrocket.data.models.Results
import com.curiousapps.myrocket.domain.Game


fun Results.toGameEntity(): GameEntity{
    return GameEntity(
        id = id,
        name = name,
        description = description,
        deck = deck,

    )
}

fun GameEntity.toGame(): Game{
    return Game(
        id = id,
        name = name,
        description = description,
        deck = deck,
        imageUrl = Image.imageUrl
    )
}