package com.example.kotlinnotes.ui.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinnotes.data.NoteLogic
import com.example.kotlinnotes.data.model.Note
import com.example.kotlinnotes.databinding.ActivityNotesBinding
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity(){

    private lateinit var noteAdapter: NoteLogic
    private lateinit var binding: ActivityNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        noteAdapter = NoteLogic(mutableListOf())

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
}