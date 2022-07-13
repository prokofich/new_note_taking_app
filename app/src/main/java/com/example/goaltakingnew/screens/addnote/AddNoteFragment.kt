package com.example.goaltakingnew.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.goaltakingnew.APP
import com.example.goaltakingnew.R
import com.example.goaltakingnew.databinding.FragmentAddNoteBinding
import com.example.goaltakingnew.model.NoteModel


class AddNoteFragment : Fragment() {


    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init() //вызов функции инициализации

    }

    private fun init(){
        val viewmodel = ViewModelProvider(this).get(AddNoteViewModel::class.java)//получение доступа к viewmodel для вызова функции
        binding.idBtnAddNote.setOnClickListener {
            val title = binding.idEtAddTitle.text.toString()
            val description = binding.idEtAddDescription.text.toString()
            viewmodel.insert(NoteModel(title = title,description = description)){}//вызов функции добавления заметки
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)//переход на начальный фрагмент
        }
        binding.idBtnBack.setOnClickListener{
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)//переход на начальный фрагмент
        }
    }


}