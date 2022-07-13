package com.example.goaltakingnew.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
class NoteModel ( //модель для записи в базу данных-заметка(имеет два поля: заголовок и описание)

    @PrimaryKey(autoGenerate = true) //ID (номер:0,1,2...... и тд)
    var id:Int = 0,

    @ColumnInfo
    var title:String = "",//заголовок

    @ColumnInfo
    var description:String = ""//описание

) : Serializable //для того,чтобы можно было сериализовать(обьединить объект в бандл)