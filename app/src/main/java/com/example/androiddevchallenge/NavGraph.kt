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
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.CAT_DETAIL_ID_KEY
import com.example.androiddevchallenge.MainDestinations.CAT_DETAIL_ROUTE
import com.example.androiddevchallenge.MainDestinations.CAT_LIST_ROUTE
import com.example.androiddevchallenge.ui.screens.CatDetailScreen
import com.example.androiddevchallenge.ui.screens.CatListScreen

object MainDestinations {
    const val CAT_LIST_ROUTE = "cats"
    const val CAT_DETAIL_ID_KEY = "catId"
    const val CAT_DETAIL_ROUTE = "cat"
}

@Composable
fun NavGraph(startDestination: String = CAT_LIST_ROUTE) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(CAT_LIST_ROUTE) { CatListScreen(navController) }
        composable(
            "$CAT_DETAIL_ROUTE/{$CAT_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(CAT_DETAIL_ID_KEY) { type = NavType.IntType })
        ) { backStackEntry ->
            CatDetailScreen(
                navController,
                requireNotNull(backStackEntry.arguments).getInt(CAT_DETAIL_ID_KEY)
            )
        }
    }
}
