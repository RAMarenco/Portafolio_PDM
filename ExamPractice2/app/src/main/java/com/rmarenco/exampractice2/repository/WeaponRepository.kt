package com.rmarenco.exampractice2.repository

import com.rmarenco.exampractice2.data.model.WeaponModel

class WeaponRepository(private val weapons: MutableList<WeaponModel> ) {
    fun getWeapons() = weapons

    fun addWeapon(weapon: WeaponModel) = weapons.add(weapon)
}