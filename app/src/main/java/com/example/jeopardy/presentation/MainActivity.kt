package com.example.jeopardy.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jeopardy.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val childrenValue = mapOf<String, String>(
            "screen" to "screen",
            "question" to "question"
        )
        val fDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
        val gameRef: DatabaseReference = fDatabase?.getReference("game")
        gameRef.updateChildren(childrenValue)
    }

}