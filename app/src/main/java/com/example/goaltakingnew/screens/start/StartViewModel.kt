package com.example.goaltakingnew.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.goaltakingnew.REPOSITORY
import com.example.goaltakingnew.database.NoteDatabase
import com.example.goaltakingnew.model.NoteModel
import com.example.goaltakingnew.repository.NoteRealisation

class StartViewModel(application: Application): AndroidViewModel(application) {

    val context  = application

    fun initDatabase(){//функция инициализации базы данных
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun getAllNotes():LiveData<List<NoteModel>>{ //функция возвращения списка всех заметок
        return REPOSITORY.allNotes
    }

}