package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R

data class Cat(
    val id: Int,
    val name: String,
    val image: Int
)

val catsSeed = listOf(
    Cat(1, "Mugi", R.drawable.cat_1),
    Cat(2, "Sora", R.drawable.cat_2),
    Cat(3, "Reo", R.drawable.cat_3),
    Cat(4, "Coco", R.drawable.cat_4),
    Cat(5, "Maru", R.drawable.cat_5),
)
