package com.example.homework_98515
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember

@Composable
fun MSList(
    list: List<MS>,
    onRemoveMovie: (MS) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(items = list, key = { movie -> movie.id }) { movie ->
            MSListItem(movieName = movie.label, onRemove = {onRemoveMovie(movie)})
        }
    }
}
