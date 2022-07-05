package com.example.jeopardy.domain.models

data class Question(
    val description: String,
    val complexity: Long,
    val answer: String,
    val theme: Theme
)
