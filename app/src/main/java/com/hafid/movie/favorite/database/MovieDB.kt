package com.hafid.movie.favorite.database

import androidx.room.Database
import androidx.room.Room
import android.content.Context
import androidx.room.RoomDatabase

import com.hafid.movie.movie.data.ResultsItem

@Database(entities = [ResultsItem::class], version = 1, exportSchema = false)
abstract class MovieDB : RoomDatabase(){
    abstract fun movieDao():MovieDao

    companion object{
        private const val DB_NAME = "move_testing_db"
        private var dbIntance : MovieDB? = null


        fun getDatabase(context : Context): MovieDB{
            if (dbIntance == null){
                dbIntance = Room
                    .databaseBuilder(context.applicationContext, MovieDB::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .build()
            }
            return dbIntance as MovieDB
        }
    }

}