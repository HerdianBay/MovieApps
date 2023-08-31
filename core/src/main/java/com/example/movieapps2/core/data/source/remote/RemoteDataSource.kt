package com.example.movieapps2.core.data.source.remote

import android.util.Log
import com.example.movieapps2.core.data.source.remote.network.ApiResponse
import com.example.movieapps2.core.data.source.remote.network.ApiService
import com.example.movieapps2.core.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllMovie() : Flow<ApiResponse<List<MovieResponse>>> {
        return flow {
            try {
                val response = apiService.getMovie("c201ca1bc425d7bcf0d41759c633cb3d")
                val dataArray = response.result
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.result))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.d("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}