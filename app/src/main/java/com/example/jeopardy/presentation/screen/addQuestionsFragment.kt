package com.example.jeopardy.presentation.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jeopardy.R
import com.example.jeopardy.databinding.FragmentAddQuestionsBinding
import com.example.jeopardy.databinding.FragmentMainBinding

class addQuestionsFragment : Fragment(R.layout.fragment_add_questions) {

    private lateinit var binding: FragmentAddQuestionsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddQuestionsBinding.bind(view)
    }

    companion object {

    }
}