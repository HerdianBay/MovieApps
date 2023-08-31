package com.example.movieapps2.core.domain.usecase

import com.example.movieapps2.core.domain.model.Movie
import com.example.movieapps2.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {

    override fun getAllListMovie() = movieRepository.getAllListMovie()

    override fun getFavoriteMovie() = movieRepository.getFavoriteMovie()

    override fun updateFavoriteMovie(movie: Movie, newState: Boolean) = movieRepository.updateFavoriteMovie(movie, newState)

    override fun getSearchMovie(search: String): Flow<List<Movie>> = movieRepository.getSearchMovie(search)
}