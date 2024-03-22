package com.curiousapps.myrocket.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllGames(results: List<GameEntity>)

    @Query(
        """
        SELECT *
        FROM GameEntity
        WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%'        
    """
    )
    suspend fun searchGames(query: String): List<GameEntity>
    @Query("DELETE FROM gameentity")
    suspend fun clearAllGames()
}