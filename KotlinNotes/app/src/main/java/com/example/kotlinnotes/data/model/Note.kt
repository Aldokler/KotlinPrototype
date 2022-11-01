package com.example.kotlinnotes.data.model

data class Note (
    val title: String,
    val content: String,
    var checked: Boolean = false
)