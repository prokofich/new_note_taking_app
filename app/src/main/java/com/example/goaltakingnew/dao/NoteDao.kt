package com.example.goaltakingnew.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.goaltakingnew.model.NoteModel

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel) //функция добавления с аннотацией

    @Delete
    suspend fun delete(noteModel: NoteModel) //функция удаления с аннотацией

    @Query("SELECT * from note_table") //отображение все таблицы данных(запрос)
    fun getAllNotes():LiveData<List<NoteModel>>
}