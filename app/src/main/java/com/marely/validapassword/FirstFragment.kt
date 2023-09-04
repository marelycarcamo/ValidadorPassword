package com.marely.validapassword

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =inflater.inflate(R.layout.fragment_first, container, false)
        val idButton = root.findViewById<Button>(R.id.idButton)
        val editText = root.findViewById<TextInputEditText>(R.id.idEditText)

        editText.addTextChangedListener {
            val text = it.toString()
            val hasUpperCase = text.any { it -> it.isUpperCase() }
            Log.i("marely","$hasUpperCase")
            idButton.isEnabled = editText.length() >= 5 && hasUpperCase == true

        }

        idButton.setOnClickListener {
            findNavController().navigate(R.id.action_first_Fragment_to_second_Fragment)
            editText.setText("")

        }
      
        return root
    }
}






