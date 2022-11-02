package com.example.kotlinnotes.ui.notes

import com.example.kotlinnotes.data.model.Note

data class User(
    val user: String,
    val password: String,
    var notes: MutableList<Note> = mutableListOf(Note("Kotlin es un lenguaje de programación... ","a"),
        Note("Nueva nota :)","a"),
        Note("a... \n b...","a"),
        )
){
    fun addNote(note:Note){
        notes.add(note)
    }



}