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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.MainDestinations.CAT_DETAIL_ROUTE
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.catsSeed

@Composable
fun CatListScreen(
    navController: NavController,
    cats: List<Cat> = catsSeed
) {
    CatList(cats) { cat ->
        navController.navigate("$CAT_DETAIL_ROUTE/${cat.id}")
    }
}

@Composable
fun CatList(
    cats: List<Cat>,
    onClick: (cat: Cat) -> Unit
) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(cats) { cat ->
            CatCard(cat) { onClick(cat) }
        }
    }
}

@Composable
private fun CatCard(
    cat: Cat,
    onClick: () -> Unit
) {
    Row(
        Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = onClick)
            .fillMaxWidth()
    ) {
        CatImage(cat)
        Spacer(Modifier.requiredWidth(24.dp))
        CatExplain(cat)
    }
}

@Composable
private fun CatImage(cat: Cat) {
    Surface(
        modifier = Modifier.size(84.dp),
        shape = CircleShape,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
    ) {
        Image(painter = painterResource(cat.image), contentDescription = cat.name)
    }
}

@Composable
private fun CatExplain(cat: Cat) {
    Column {
        Text(cat.name, fontSize = 24.sp)
        Spacer(Modifier.requiredHeight(8.dp))
        Row {
            Text(cat.genderType.name, color = Color(cat.genderType.color), fontSize = 16.sp)
            Spacer(Modifier.requiredWidth(8.dp))
            Text(cat.old, color = Color.Gray, fontSize = 16.sp)
        }
        Spacer(Modifier.requiredHeight(4.dp))
        Text(cat.hometown, color = Color.Gray, fontSize = 16.sp)
    }
}

@Composable
@Preview
private fun CatListPreview() {
    CatList(
        cats = catsSeed,
        onClick = {}
    )
}
