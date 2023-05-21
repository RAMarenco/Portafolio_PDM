package com.rmarenco.exampractice2.data

import com.rmarenco.exampractice2.data.model.WeaponModel

val weapon1 = WeaponModel("Claymore", 250, 20, "Heavy Slash", "None", "Great Sword")
val weapon2 = WeaponModel("Long Sword", 30, 0, "None", "None", "Long Sword")
val weapon3 = WeaponModel("Spiked Hammer", 400, 0, "Smash", "Earthquake", "Hammer")
val weapon4 = WeaponModel("Holy bow", 20, 0, "Multishot (5 arrows)", "Holy Arrow", "Bow")

var weapons = mutableListOf(weapon1, weapon2, weapon3, weapon4);