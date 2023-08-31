package com.example.movieapps2.core.data.source.local

import com.example.movieapps2.core.data.source.local.entity.MovieEntity
import com.example.movieapps2.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllListMovie() : Flow<List<MovieEntity>> = movieDao.getAllListMovie()

    fun getFavoriteMovie() : Flow<List<MovieEntity>> = movieDao.getFavoriteMovie()

    suspend fun insertMovie(movie : List<MovieEntity>) = movieDao.insertMovie(movie)

    fun updateFavoriteMovie(movie : MovieEntity, newState : Boolean) {
        movie.favorite = newState
        movieDao.updateFavoriteMovie(movie)
    }

    fun getSearchMovie(search : String) = movieDao.getSearchMovie(search)
}