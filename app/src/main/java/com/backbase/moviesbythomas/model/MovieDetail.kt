package com.backbase.moviesbythomas.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieDetail(
    val adult : Boolean?,
    val backdrop_path : String?,
    val homepage : String?,
    val id : Int?,
    val imdb_id : String?
) : Parcelable
