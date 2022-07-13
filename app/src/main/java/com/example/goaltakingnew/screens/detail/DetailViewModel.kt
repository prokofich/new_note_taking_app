package com.example.goaltakingnew.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goaltakingnew.REPOSITORY
import com.example.goaltakingnew.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel:ViewModel() {

    fun delete(noteModel: NoteModel, onSuccess:() ->Unit) = //функция удаления заметки
        viewModelScope.launch (Dispatchers.IO){ //корутина используется в потоке IО,чтобы не замедлять основной поток MAIN
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }

}