package com.hafid.movie.favorite.database



import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

import com.hafid.movie.movie.data.ResultsItem


@Dao
interface MovieDao {

    @get:Query("SELECT * FROM favorite_movie")
    val all : List<ResultsItem>

    //select
    @Query("SELECT * FROM favorite_movie WHERE id= :id")
    fun getId(id : Int?) : ResultsItem

    //insert
    @Insert(onConflict = REPLACE)
    fun insertMovie(movie: ResultsItem)

    //delete
    @Delete
    fun delete(movie: ResultsItem)

    @Query("DELETE from favorite_movie WHERE id= :id")
    fun deleteById(id: Int?)
}