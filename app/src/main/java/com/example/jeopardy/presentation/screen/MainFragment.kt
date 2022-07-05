package com.example.jeopardy.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.jeopardy.R
import com.example.jeopardy.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        updateUI()
        binding.addQuestions.setOnClickListener {
            gotoAddQuestion()
        }

    }

    private fun updateUI() {
        if (USER_ROLE == "Администратор") {
            binding.addQuestions.visibility = View.VISIBLE
            binding.changeQuestions.visibility = View.VISIBLE
        } else {
            binding.addQuestions.visibility = View.GONE
            binding.changeQuestions.visibility = View.GONE
        }
    }

    private fun gotoAddQuestion() {
        findNavController().navigate(
            R.id.action_mainFragment_to_selectSectionFragment
        )
    }

    companion object {
        const val USER = "Виктор"
        const val USER_ROLE = "Администратор"
    }
}