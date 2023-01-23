package com.example.pifsportapp.RoomData

import androidx.room.*
import com.example.pifsportapp.data.MatchCreatedData

@Dao
interface MatchDao {


    // We don't need suspend ere because it happened in the Flow
    // Flow is asynconans stream of data
    @Query("SELECT * FROM Match_table ORDER BY created_date ASC")
    fun getMatches():List<MatchCreatedData>

    @Insert
    suspend fun insert(match: MatchCreatedData)

    @Update
    suspend fun update(match: MatchCreatedData)

    @Delete
    suspend fun delete(match: MatchCreatedData)
}