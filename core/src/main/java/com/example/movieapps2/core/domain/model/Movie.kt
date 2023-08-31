package com.example.movieapps2.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id : Int,
    val title : String,
    val overview : String,
    val releaseDate : String,
    val popularity : Double,
    val voteAverage : Double,
    val posterPath : String,
    val voteCount : Int,
    val favorite : Boolean
) : Parcelable