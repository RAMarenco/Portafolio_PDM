package com.rmarenco.shareviewmodel.ui.money

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

class MoneyFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var saveButton: Button
    private lateinit var moneyEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_money, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        addListener()

        if (viewModel.money.isNotEmpty()) moneyEditText.setText(viewModel.money)
    }

    private fun addListener() {
        saveButton.setOnClickListener {
            viewModel.money = moneyEditText.text.toString()
        }
    }

    private fun bind(view: View) {
        saveButton = view.findViewById(R.id.save_action)
        moneyEditText = view.findViewById(R.id.money_editText)
    }
}