package com.example.pifsportapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import androidx.room.Entity
import androidx.room.PrimaryKey

@Parcelize
@Entity(tableName ="Match_table")
data class MatchCreatedData(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var date: String,
    var time: String,
    var location : String?,
    var created_date: String
    ):Parcelable

annotation class Parcelize

