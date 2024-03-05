package com.curiousapps.myrocket.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.curiousapps.myrocket.data.models.Image

@Entity
data class GameEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val deck: String,
)
