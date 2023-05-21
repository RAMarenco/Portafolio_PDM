package com.rmarenco.exampractice2.ui.weapon.weapons.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rmarenco.exampractice2.data.model.WeaponModel
import com.rmarenco.exampractice2.databinding.WeaponItemBinding

class WeaponReclyclerViewAdapter(private val onClickWeapon: (WeaponModel) -> Unit) :
    RecyclerView.Adapter<WeaponReclyclerViewAdapter.ViewHolderWeapon>() {
    private var weapons: List<WeaponModel>? = null

    class ViewHolderWeapon(private val binding: WeaponItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(weapon: WeaponModel, onClickWeapon: (WeaponModel) -> Unit) {
            binding.weaponName.text = weapon.name
            binding.weaponAtk.text = weapon.damage.toString()
            binding.weaponDef.text = weapon.defense.toString()

            binding.weaponCard.setOnClickListener {
                onClickWeapon(weapon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderWeapon {
        val binding = WeaponItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderWeapon(binding)
    }

    override fun getItemCount(): Int = weapons?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderWeapon, position: Int) {
        weapons?.let {
            holder.bind(it[position], onClickWeapon)
        }
    }

    fun setData(weapons: List<WeaponModel>) {
        this.weapons = weapons
    }
}