package com.curiousapps.myrocket.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.curiousapps.myrocket.data.models.Results

@Dao
interface GameDao {

//    @Upsert
//    suspend fun upsertAll(results: List<Results>)

//    @Query("SELECT * FROM gameentity")
//    fun pagingSource(): PagingSource<Int, GameEntity>
//
//    @Query("DELETE FROM gameentity")
//    suspend fun clearAll()
}