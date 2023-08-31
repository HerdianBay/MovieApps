package com.example.movieapps2.detail

import androidx.lifecycle.ViewModel
import com.example.movieapps2.core.domain.model.Movie
import com.example.movieapps2.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun updateFavoriteMovie(movie : Movie, newState : Boolean) {
        movieUseCase.updateFavoriteMovie(movie, newState)
    }
}