package com.example.movieapps2.core.data.source.local.room

import androidx.room.*
import com.example.movieapps2.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllListMovie() : Flow<List<MovieEntity>>

    @Query("SELECT * FROM movie WHERE favorite = 1")
    fun getFavoriteMovie() : Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movie : List<MovieEntity>)

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)

    @Query("SELECT * FROM movie WHERE title LIKE '%' || :search || '%'")
    fun getSearchMovie(search : String) : Flow<List<MovieEntity>>
}