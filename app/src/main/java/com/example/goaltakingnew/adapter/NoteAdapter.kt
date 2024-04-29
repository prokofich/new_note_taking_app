package com.example.goaltakingnew.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.goaltakingnew.R
import com.example.goaltakingnew.model.NoteModel
import com.example.goaltakingnew.screens.start.StartFragment
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.concurrent.RecursiveAction


class NoteAdapter:RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    var listNote = emptyList<NoteModel>() //список в заметками

    class NoteViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.itemView.id_item_title.text = listNote[position].title

    }

    override fun getItemCount(): Int {
        return listNote.size

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<NoteModel>){
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener { null }
    }

}