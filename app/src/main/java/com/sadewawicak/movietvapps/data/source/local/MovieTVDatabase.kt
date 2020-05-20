package com.sadewawicak.movietvapps.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.local.room.MovieDao
import com.sadewawicak.movietvapps.data.source.local.room.TVDao

@Database(entities = [MovieEntity::class,TvEntity::class], version = 2, exportSchema = false)
abstract class MovieTVDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TVDao

    companion object {
        private const val DATABASE_NAME = "moviestvapps"
        private var mInstance: MovieTVDatabase? = null

        fun getInstance(context: Context): MovieTVDatabase? {
            if (mInstance == null) {
                synchronized(MovieTVDatabase::class) {
                    mInstance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieTVDatabase::class.java, DATABASE_NAME
                    ).build()
                }
            }
            return mInstance
        }
    }

}