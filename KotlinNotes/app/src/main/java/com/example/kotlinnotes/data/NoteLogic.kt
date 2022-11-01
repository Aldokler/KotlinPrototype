package com.example.kotlinnotes.data

import android.annotation.SuppressLint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnotes.R
import com.example.kotlinnotes.data.model.Note
import com.example.kotlinnotes.databinding.ActivityNoteBinding
import kotlinx.android.synthetic.main.activity_note.view.*


class NoteLogic(
    private val notas: MutableList<Note>
) : RecyclerView.Adapter<NoteLogic.NoteViewHolder>(){

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
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

    @SuppressLint("NotifyDataSetChanged")
    fun burnNotes(){
        notas.removeAll { nota ->
            nota.checked
        }
        notifyDataSetChanged()
    }

    private fun markSelected(title: TextView, casilla: Boolean){
        if(casilla){
            title.paintFlags = title.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            title.paintFlags = title.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val curNote = notas[position]
        println(curNote)
        holder.itemView.apply {
            noteTitle.text = curNote.title
            checkBox.isChecked = curNote.checked
            markSelected(noteTitle, curNote.checked)
            checkBox.setOnCheckedChangeListener { _, b ->
                markSelected(noteTitle, b)
                curNote.checked = !curNote.checked
            }
        }
    }

    override fun getItemCount(): Int {
        return notas.size
    }
}