package com.example.pifsportapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pifsportapp.RoomData.MatchRepo
import com.example.pifsportapp.data.MatchCreatedData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchViewModel (context : Application) : AndroidViewModel(context){


    private val repo = MatchRepo(context)

    // to deal with Live Data < Mutable to be able to change
    fun getMatch(): MutableLiveData<List<MatchCreatedData>> {
        val match = MutableLiveData<List<MatchCreatedData>>()
        viewModelScope.launch {
        // post
        match.postValue(repo.getMatches())
        }
        return match
    }
    // we don't need to observe  here

    fun insertMatch(match: MatchCreatedData) = viewModelScope.launch(Dispatchers.IO) {
        repo.insertMatch(match)
    }

    fun updateMatch(match: MatchCreatedData){
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateMatch(match)
        }
    }


    fun deleteMatch(match: MatchCreatedData){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteMatch(match)
        }
    }
}