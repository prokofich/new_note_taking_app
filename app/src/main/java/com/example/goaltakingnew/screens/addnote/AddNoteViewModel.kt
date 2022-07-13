package com.example.goaltakingnew.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goaltakingnew.REPOSITORY
import com.example.goaltakingnew.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel:ViewModel() {

    fun insert(noteModel:NoteModel,onSuccess:() ->Unit) = //функция добавления заметки
        viewModelScope.launch (Dispatchers.IO){//корутина используется в потоке IO,чтобы не замедлять основной поток MAIN
            REPOSITORY.insertNote(noteModel){
                onSuccess()
            }
        }

}