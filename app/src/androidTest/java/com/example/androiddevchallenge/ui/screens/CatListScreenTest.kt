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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.example.androiddevchallenge.MainActivity
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.catsSeed
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CatListScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private val cats = catsSeed

    private lateinit var tappedCat: Cat

    @Before
    fun setUp() {
        composeTestRule.setContent {
            CatList(cats = cats, onClick = { cat -> tapCat(cat) })
        }
    }

    @Test
    fun showCatList() {
        cats.forEach { cat ->
            composeTestRule.onNodeWithContentDescription(cat.name).assertIsDisplayed()
        }
    }

    @Test
    fun tapCatTest() {
        val willTapCat = cats[2]
        composeTestRule.onNodeWithContentDescription(willTapCat.name).performClick()
        assert(tappedCat == willTapCat)
    }

    private fun tapCat(cat: Cat) {
        tappedCat = cat
    }
}
