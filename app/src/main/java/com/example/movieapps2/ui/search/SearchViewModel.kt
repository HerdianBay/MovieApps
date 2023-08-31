package com.example.movieapps2.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieapps2.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

@FlowPreview
@ExperimentalCoroutinesApi
class SearchViewModel(movieUseCase: MovieUseCase) : ViewModel() {

//    val movie = ConflatedBroadcastChannel<String>()
//
//    val searchMovie = movie.asFlow()
//        .debounce(300)
//        .distinctUntilChanged()
//        .filter {
//            it.trim().isNotEmpty()
//        }
//        .flatMapLatest {
//            movieUseCase.getSearchMovie(it)
//        }
//        .asLiveData()

    val movie = MutableStateFlow("")

    val searchMovie = movie
        .debounce(300)
        .distinctUntilChanged()
        .filter { it.trim().isNotEmpty() }
        .flatMapLatest { movieUseCase.getSearchMovie(it) }
        .asLiveData()
}