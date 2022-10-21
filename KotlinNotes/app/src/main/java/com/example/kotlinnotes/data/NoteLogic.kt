package com.example.kotlinnotes.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnotes.R
import com.example.kotlinnotes.data.model.Note
import com.example.kotlinnotes.databinding.ActivityNoteBinding
import com.example.kotlinnotes.databinding.ActivityNotesBinding


class NoteLogic(
    private val notas: MutableList<Note>
) : RecyclerView.Adapter<NoteLogic.NoteViewHolder>(){

    private lateinit var binding: ActivityNoteBinding

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        binding = ActivityNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_note,
                parent,
                false
            )
        )
    }

    fun newNote(nota: Note){
        notas.add(nota)
        notifyItemInserted(notas.size-1)
    }

    fun burnNote(){
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val curNote = notas[position]
        holder.itemView.apply {
            binding.noteTitle.text = curNote.title
        }
    }

    override fun getItemCount(): Int {
        return notas.size
    }
}