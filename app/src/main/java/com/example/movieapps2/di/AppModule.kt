package com.example.movieapps2.di

import com.example.movieapps2.core.domain.usecase.MovieInteractor
import com.example.movieapps2.core.domain.usecase.MovieUseCase
import com.example.movieapps2.detail.DetailViewModel
import com.example.movieapps2.ui.home.HomeViewModel
import com.example.movieapps2.ui.search.SearchViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}