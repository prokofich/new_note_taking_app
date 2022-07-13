package com.example.goaltakingnew.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.goaltakingnew.dao.NoteDao
import com.example.goaltakingnew.model.NoteModel

@Database(entities = [NoteModel::class],version = 1)
abstract class NoteDatabase:RoomDatabase() {

    abstract fun getNoteDao():NoteDao //сама база данных

    companion object{
        private var database:NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context):NoteDatabase{
            return if(database == null){
                database = Room.databaseBuilder(context,NoteDatabase::class.java,"db").build() //создание базы,если ее нет
                database as NoteDatabase
            }else{
                database as NoteDatabase
            }
        }
    }

}