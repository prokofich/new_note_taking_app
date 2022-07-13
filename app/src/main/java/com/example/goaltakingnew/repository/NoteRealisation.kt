package com.example.goaltakingnew.repository

import androidx.lifecycle.LiveData
import com.example.goaltakingnew.dao.NoteDao
import com.example.goaltakingnew.model.NoteModel

class NoteRealisation(private val noteDao: NoteDao):NoteRepository {



    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }


}