package com.rmarenco.shareviewmodel.ui.lastname

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import com.rmarenco.shareviewmodel.R
import com.rmarenco.shareviewmodel.ui.MainViewModel

class LastnameFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var saveButton: Button
    private lateinit var lastNameEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lastname, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        addListener()

        if (viewModel.lastname.isNotEmpty()) lastNameEditText.setText(viewModel.lastname)
    }

    private fun addListener() {
        saveButton.setOnClickListener {
            viewModel.lastname = lastNameEditText.text.toString()
        }
    }

    private fun bind(view: View) {
        saveButton = view.findViewById(R.id.save_action)
        lastNameEditText = view.findViewById(R.id.lastName_editText)
    }
}