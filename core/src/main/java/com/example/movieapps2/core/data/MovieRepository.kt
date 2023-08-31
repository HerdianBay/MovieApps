package com.example.movieapps2.core.data

import com.example.movieapps2.core.data.source.local.LocalDataSource
import com.example.movieapps2.core.data.source.remote.RemoteDataSource
import com.example.movieapps2.core.data.source.remote.network.ApiResponse
import com.example.movieapps2.core.data.source.remote.response.MovieResponse
import com.example.movieapps2.core.domain.model.Movie
import com.example.movieapps2.core.domain.repository.IMovieRepository
import com.example.movieapps2.core.utils.AppExecutors
import com.example.movieapps2.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllListMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllListMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllMovie()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovie().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun updateFavoriteMovie(movie: Movie, newState: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.updateFavoriteMovie(movieEntity, newState) }
    }

    override fun getSearchMovie(search: String): Flow<List<Movie>> {
        return localDataSource.getSearchMovie(search).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }


}