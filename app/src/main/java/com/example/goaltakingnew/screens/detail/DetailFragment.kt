package com.example.goaltakingnew.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.goaltakingnew.APP
import com.example.goaltakingnew.R
import com.example.goaltakingnew.databinding.FragmentDetailBinding
import com.example.goaltakingnew.model.NoteModel


class DetailFragment : Fragment() {

    lateinit var binding: FragmentDetailBinding
    lateinit var currentNote:NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater,container,false)
        currentNote = arguments?.getSerializable("note") as NoteModel //получения объекта из бандла
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()//вызов функции инициализации
    }


    private fun init(){
        val viewmodel = ViewModelProvider(this).get(DetailViewModel::class.java)//получение доступа к viewmodel для вызова функции
        binding.idTvTitleDetail.text = currentNote.title //установка загаловка в поле
        binding.idTvDescroptionDetail.text = currentNote.description //установкв описания заметки в поле

        binding.idBtnDelete.setOnClickListener {
            viewmodel.delete(currentNote){} //удаление заметки
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment)//переход в начальный фрагмент со списком заметок
        }


        binding.idBtnBack.setOnClickListener {
            APP.navController.navigate(R.id.action_detailFragment_to_startFragment) //переход в начальный фрагмент со списком заметок
        }
    }


}