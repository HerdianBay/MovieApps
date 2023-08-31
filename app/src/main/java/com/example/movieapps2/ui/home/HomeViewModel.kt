package com.example.movieapps2.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieapps2.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUserCase: MovieUseCase) : ViewModel() {
    val movie = movieUserCase.getAllListMovie().asLiveData()
}