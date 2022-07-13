package com.example.goaltakingnew.repository

import androidx.lifecycle.LiveData
import com.example.goaltakingnew.model.NoteModel

interface NoteRepository {

    val allNotes: LiveData<List<NoteModel>> //список всех заметок
    suspend fun insertNote(noteModel: NoteModel,onSuccess:() ->Unit) //корутинная(прерываемая) функция добавления
    suspend fun deleteNote(noteModel: NoteModel,onSuccess:() ->Unit) //корутинаая(прерываемая) функция удаления

}