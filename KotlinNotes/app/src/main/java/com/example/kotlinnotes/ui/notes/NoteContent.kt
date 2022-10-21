package com.example.kotlinnotes.ui.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinnotes.data.NoteLogic
import com.example.kotlinnotes.data.model.Note
import com.example.kotlinnotes.databinding.ActivityContentBinding
import com.example.kotlinnotes.databinding.ActivityNotesBinding

class NoteContent : AppCompatActivity() {

    private lateinit var noteAdapter: NoteLogic
    private lateinit var binding: ActivityContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        noteAdapter = NoteLogic(mutableListOf())

    }

}