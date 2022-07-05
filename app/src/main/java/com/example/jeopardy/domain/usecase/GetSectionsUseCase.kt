package com.example.jeopardy.domain.usecase

import com.example.jeopardy.domain.models.Section

class GetSectionsUseCase {

    fun execute(): List<Section> {
        return listOf<Section>(
            Section("Общее"),
            Section("Кино"),
            Section("Музыка"),
            Section("Футбол")
        )
    }

}