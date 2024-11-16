package com.example.homework_98515

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MoviesSeriesScreen(
    modifier: Modifier = Modifier,
    msViewModel: MSViewModel = viewModel()
    ) {
    Column(modifier = modifier) {
        StatefulCounter()

        MSList(list = msViewModel.movie, onRemoveMovie = { task -> msViewModel.remove(task) })
    }
}
