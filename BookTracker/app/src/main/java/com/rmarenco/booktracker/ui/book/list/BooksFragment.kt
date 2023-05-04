package com.rmarenco.booktracker.ui.book.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rmarenco.booktracker.R
import com.rmarenco.booktracker.databinding.FragmentBooksBinding
import com.rmarenco.booktracker.ui.book.list.BookAdapter
import com.rmarenco.booktracker.ui.book.list.BooksViewModel

class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    private val viewModel: BooksViewModel by viewModels {
        BooksViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_books, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookAdapter {
            Toast.makeText(requireContext(), "Click en ${it.title}", Toast.LENGTH_LONG).show()
        }

        binding.recylerViewBooks.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.getBooks().observe(viewLifecycleOwner) { books ->
            adapter.submitData(books)
            adapter.notifyDataSetChanged()
        }

        binding.addBookAction.setOnClickListener{
            findNavController().navigate(R.id.action_booksFragment_to_newBookFragment2)
        }
    }
}