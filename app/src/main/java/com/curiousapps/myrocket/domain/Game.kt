package com.curiousapps.myrocket.domain

import com.curiousapps.myrocket.data.models.Image

data class Game(

    val id: Int,
    val name: String,
    val description: String,
    val deck: String,
    val imageUrl: Image,

)
