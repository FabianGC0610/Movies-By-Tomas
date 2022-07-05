package com.backbase.moviesbythomas.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoviesResponse(
    val page : Int?,
    val results: List<Results>,
    val dates: Dates? = Dates("",""),
    val total_pages : Int?,
    val total_results : Int?
) : Parcelable
