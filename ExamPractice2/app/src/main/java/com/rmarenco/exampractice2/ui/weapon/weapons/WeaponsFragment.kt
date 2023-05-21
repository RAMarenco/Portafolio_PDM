package com.rmarenco.exampractice2.ui.weapon.weapons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.rmarenco.exampractice2.R
import com.rmarenco.exampractice2.data.model.WeaponModel
import com.rmarenco.exampractice2.databinding.FragmentWeaponsBinding
import com.rmarenco.exampractice2.databinding.WeaponItemBinding
import com.rmarenco.exampractice2.ui.weapon.weapons.recyclerview.WeaponReclyclerViewAdapter
import com.rmarenco.exampractice2.viewmodel.WeaponsViewModel

class WeaponsFragment : Fragment() {
    private lateinit var binding: FragmentWeaponsBinding
    private lateinit var adapter: WeaponReclyclerViewAdapter

    private val weaponsViewModel: WeaponsViewModel by activityViewModels {
        WeaponsViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeaponsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        val adapter = WeaponReclyclerViewAdapter { selectedWeapon ->
            showSelectedItem(selectedWeapon)
        }

        adapter.setData(weaponsViewModel.getWeapons())
        adapter.notifyDataSetChanged()

        binding.recyclerView.adapter = adapter
    }

    private fun showSelectedItem(weapon: WeaponModel) {
        weaponsViewModel.setSelectedWeapon(weapon)
    }
}