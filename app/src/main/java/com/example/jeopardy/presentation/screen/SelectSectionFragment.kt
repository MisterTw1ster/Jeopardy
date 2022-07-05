package com.example.jeopardy.presentation.screen

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jeopardy.R
import com.example.jeopardy.databinding.FragmentSelectSectionBinding
import com.example.jeopardy.databinding.PartAnswerInputBinding
import com.example.jeopardy.domain.models.Section
import com.google.firebase.database.*

class SelectSectionFragment : Fragment(R.layout.fragment_select_section) {

    private lateinit var binding: FragmentSelectSectionBinding
    private lateinit var adapter: SectionAdapter
    private lateinit var vm: SelectSectionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSelectSectionBinding.bind(view)

        vm = ViewModelProvider(this).get(SelectSectionViewModel::class.java)
        vm.sectionsLive.observe(viewLifecycleOwner, {sections -> fillSections(sections) })
        vm.getSections()

        binding.addSection.setOnClickListener { addSection() }
    }

    private fun fillSections(sections: List<Section>) {
        adapter = SectionAdapter(sections, object : SectionActionListener {
            override fun selectSection(city: Section) {
                gotoAddQuestions()
            }

        })
        val layoutManager = LinearLayoutManager(context)
        binding.sectionsRecyclerView.layoutManager = layoutManager
        binding.sectionsRecyclerView.adapter = adapter
    }

    private fun addSection() {
        dialogInputSection()
    }

    private fun dialogInputSection() {
        val dialogBinding = PartAnswerInputBinding.inflate(layoutInflater)

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Название секции")
            .setView(dialogBinding.root)
            .setPositiveButton("Confirm", null)
            .create()

        dialog.setOnShowListener {
            dialogBinding.volumeInputEditText.requestFocus()
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                val nameSection = dialogBinding.volumeInputEditText.text.toString()
                vm.addSection(nameSection)
                dialog.dismiss()
            }
        }

        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
        dialog.show()
    }

    private fun gotoAddQuestions() {
        findNavController().navigate(
            R.id.action_selectSectionFragment_to_addQuestionsFragment
        )
    }

}