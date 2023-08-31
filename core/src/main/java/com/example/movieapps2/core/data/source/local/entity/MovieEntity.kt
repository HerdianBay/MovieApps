package com.example.movieapps2.core.data.source.local.entity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id : Int,

    @ColumnInfo(name = "title")
    var title : String,

    @ColumnInfo(name = "overview")
    var overview : String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate : String,

    @ColumnInfo(name = "popularity")
    var popularity : Double,

    @ColumnInfo(name = "voteAverage")
    var voteAverage : Double,

    @ColumnInfo(name = "posterPath")
    var posterPath: String,

    @ColumnInfo(name = "voteCount")
    var voteCount: Int,

    @ColumnInfo(name = "favorite")
    var favorite : Boolean
)