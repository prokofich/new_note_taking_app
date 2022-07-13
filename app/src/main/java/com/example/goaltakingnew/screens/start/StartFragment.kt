package com.example.goaltakingnew.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.goaltakingnew.APP
import com.example.goaltakingnew.R
import com.example.goaltakingnew.adapter.NoteAdapter
import com.example.goaltakingnew.databinding.FragmentStartBinding
import com.example.goaltakingnew.model.NoteModel


class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()//вызов функции инициализации фрагмента

    }

    private fun init(){
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)//получение доступа к viewmodel для вызова функции
        viewModel.initDatabase()//вызов функции инициализации самой базы данных

        recyclerView = binding.idRvNotes //обращение к списку через binding
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner,{listNotes -> //вызов функции получения всех заметок с помощью viewmodel

            adapter.setList(listNotes.asReversed())//реверс листа с заметками(последнее будет наверху,первое внизу)
        })

        binding.idBtnNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)//обработка перехода к начальному фрагменту
        }
    }

    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()//для передачи целого объекта в другой фрагмент
            bundle.putSerializable("note",noteModel) //добавления объекта в бандл
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment,bundle)//обработка перехода к фрагменту с детальным описанием
        }
    }


}