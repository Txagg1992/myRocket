package com.curiousapps.myrocket.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.curiousapps.myrocket.data.models.Results

@Dao
interface GameDao {

//    @Upsert
//    suspend fun upsertAll(results: List<Results>)

//    @Query("DELETE FROM ALL")
//    suspend fun clearAll()
}