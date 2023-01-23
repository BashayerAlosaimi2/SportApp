package com.example.pifsportapp.RoomData

import android.content.Context
import com.example.pifsportapp.data.MatchCreatedData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatchRepo(context: Context) {
    private val taskDB = MatchDatabase.getAppDataBase(context)!!


    suspend fun getMatches(): List<MatchCreatedData> = withContext(Dispatchers.IO) {
        taskDB.matchDau().getMatches()
    }

    suspend fun insertMatch(match: MatchCreatedData) = withContext(Dispatchers.IO) {
        taskDB.matchDau().insert(match)
    }


    suspend fun updateMatch(match: MatchCreatedData)= withContext(Dispatchers.IO) {
        taskDB.matchDau().update(match)
    }


    suspend fun deleteMatch(match: MatchCreatedData)= withContext(Dispatchers.IO) {
        taskDB.matchDau().delete(match)
    }
}


