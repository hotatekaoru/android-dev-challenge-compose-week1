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

    private lateinit var tappedCat : Cat

    @Before
    fun setUp() {
        composeTestRule.setContent {
            CatList(cats = cats, onClick = { cat -> tapCat(cat) } )
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
