package com.example.movieapps2.core.utils

import com.example.movieapps2.core.data.source.local.entity.MovieEntity
import com.example.movieapps2.core.data.source.remote.response.MovieResponse
import com.example.movieapps2.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input : List<MovieResponse>) : List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                voteCount = it.voteCount,
                favorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input : List<MovieEntity>) : List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                releaseDate = it.releaseDate,
                popularity = it.popularity,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                voteCount = it.voteCount,
                favorite = it.favorite
            )
        }

    fun mapDomainToEntity(input : Movie) : MovieEntity =
        MovieEntity(
            id = input.id,
            title = input.title,
            overview = input.overview,
            releaseDate = input.releaseDate,
            popularity = input.popularity,
            voteAverage = input.voteAverage,
            posterPath = input.posterPath,
            voteCount = input.voteCount,
            favorite = input.favorite
        )
}