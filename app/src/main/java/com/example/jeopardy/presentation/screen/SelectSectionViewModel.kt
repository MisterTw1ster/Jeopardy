package com.example.jeopardy.presentation.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jeopardy.domain.models.AddSectionParam
import com.example.jeopardy.domain.models.Section
import com.example.jeopardy.domain.usecase.AddSectionUseCase
import com.example.jeopardy.domain.usecase.GetSectionsUseCase
import com.google.firebase.database.*

class SelectSectionViewModel: ViewModel() {

    private val getSectionsUseCase = GetSectionsUseCase()
    private val addSectionUseCase = AddSectionUseCase()

    private var sectionsLiveMutable = MutableLiveData<List<Section>>()
    val sectionsLive = sectionsLiveMutable

    private var sectionsRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("sections")

    fun addSection(nameSection: String) {
        addSectionUseCase.execute(AddSectionParam(nameSection))
    }

    fun getSections() {
//        sectionsLiveMutable.value = getSectionsUseCase.execute()
        sectionsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val sectionsFB = snapshot.value as HashMap<String, String>
                val sections = mutableListOf<Section>()
                sectionsFB.forEach { sections.add(Section(it.value)) }
                sectionsLiveMutable.value = sections
             }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        )

    }

}