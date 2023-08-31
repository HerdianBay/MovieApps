package com.example.movieapps2.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(

    @field:SerializedName("results")
    val result : List<MovieResponse>

)

data class MovieResponse(

    @field:SerializedName("id")
    val id : Int,

    @field:SerializedName("title")
    var title : String,

    @field:SerializedName("overview")
    var overview : String,

    @field:SerializedName("release_date")
    var releaseDate : String,

    @field:SerializedName("popularity")
    var popularity : Double,

    @field:SerializedName("vote_average")
    var voteAverage : Double,

    @field:SerializedName("poster_path")
    var posterPath: String,

    @field:SerializedName("vote_count")
    var voteCount: Int

)