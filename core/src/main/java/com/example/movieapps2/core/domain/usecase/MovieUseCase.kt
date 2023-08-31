package com.example.movieapps2.core.domain.usecase

import com.example.movieapps2.core.data.Resource
import com.example.movieapps2.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllListMovie() : Flow<Resource<List<Movie>>>
    fun getFavoriteMovie() : Flow<List<Movie>>
    fun updateFavoriteMovie(movie: Movie, newState : Boolean)
    fun getSearchMovie(search : String) : Flow<List<Movie>>
}