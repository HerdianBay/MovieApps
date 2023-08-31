package com.example.movieapps2.core.data.source.remote.network

import com.example.movieapps2.core.data.source.remote.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie")
    suspend fun getMovie(
        @Query("api_key") apiKey : String
    ) : MovieListResponse
}