/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
