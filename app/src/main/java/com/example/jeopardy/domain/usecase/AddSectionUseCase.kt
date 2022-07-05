package com.example.jeopardy.domain.usecase

import com.example.jeopardy.domain.models.AddSectionParam
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddSectionUseCase {

    fun execute(param: AddSectionParam) {
        val childrenValue = mapOf<String, String>(
            param.hashCode().toString() to param.name
        )
        val fDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
        val sectionsRef: DatabaseReference = fDatabase?.getReference("sections")
        sectionsRef.updateChildren(childrenValue)
    }
}