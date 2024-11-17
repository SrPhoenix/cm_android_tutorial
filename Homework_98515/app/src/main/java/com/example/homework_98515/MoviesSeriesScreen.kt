package com.example.homework_98515

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
private const val TAG = "MoviesSeriesScreen"
@Composable
fun MoviesSeriesScreen(
    context: Context,
    modifier: Modifier = Modifier,
    msViewModel: MSViewModel = viewModel()
    ) {
    Column(modifier = modifier.padding(16.dp)) {
        MSList(
            list = msViewModel.movie,
            onRemoveMovie = { task -> msViewModel.remove(task) })
        FloatingActionButton(onClick = {
            showAddDialog(context, msViewModel)
        }, modifier = Modifier
            .padding(top = 16.dp)
            .align(alignment = androidx.compose.ui.Alignment.End)) {

            Icon(imageVector =
            Icons.Filled.Add, contentDescription = "Add Entry")
        }
    }
}


private fun showAddDialog(
    context: Context,
    msViewModel: MSViewModel
) {
    Log.d(TAG, "showAddDialog: button Clicked")
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    val txt = EditText(context)
    builder.setTitle("Enter Movie Name")
    val layoutName = LinearLayout(context)
    layoutName.orientation = LinearLayout.VERTICAL
    layoutName.addView(txt) // displays the user input bar
    builder.setView(layoutName)
    builder.setPositiveButton("Add") { dialog, which ->
        Log.d(TAG, "showAddDialog: Success -> ${txt.text.toString()}")
        msViewModel.add(MS(msViewModel.movie.size, txt.text.toString()))
    }
    builder.setNegativeButton("Cancel") { dialog, which ->
        Log.d(TAG, "showAddDialog: Cancel")
    }
    builder.create()
    builder.show()
}

