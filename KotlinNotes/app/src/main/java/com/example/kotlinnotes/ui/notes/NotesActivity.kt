package com.example.kotlinnotes.ui.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinnotes.data.NoteLogic
import com.example.kotlinnotes.data.model.Note
import com.example.kotlinnotes.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity(){

    private lateinit var noteAdapter: NoteLogic
    private lateinit var binding: ActivityNotesBinding
    lateinit var name:String


    private var user = User("Usuario","incorrecta")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //noteAdapter.newNote(Note("Hola", " "))

        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        noteAdapter = NoteLogic(user.notes)

        binding.rvNotesList.adapter = noteAdapter
        binding.rvNotesList.layoutManager = LinearLayoutManager(this)

        binding.add.setOnClickListener{
            val noteTitle = binding.rotulador.text.toString()
            println(noteTitle)
            if(noteTitle.isNotEmpty()){
                val nota = Note(noteTitle, " ")
                noteAdapter.newNote(nota)
                binding.rotulador.text.clear()
            }
        }

        binding.delete.setOnClickListener{
            noteAdapter.burnNotes()
            //val intent = Intent(this, NoteContent::class.java)
            //startActivity(intent)
        }
    }

    fun getUser(userName:String){
        this.name=userName
        println("AAAAAA"+ this.name)
    }
}