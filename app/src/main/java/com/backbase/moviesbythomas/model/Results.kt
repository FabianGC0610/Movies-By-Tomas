package com.backbase.moviesbythomas.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    val poster_path : String?,
    val adult : Boolean?,
    val overview : String?,
    val release_date : String?,
    val id : Int?,
    val original_title : String?,
    val original_language : String?,
    val title : String?,
    val backdrop_path : String?,
    val popularity : Double?,
    val vote_count : Int?,
    val video : Boolean?,
    val vote_average : Double?
) : Parcelable
