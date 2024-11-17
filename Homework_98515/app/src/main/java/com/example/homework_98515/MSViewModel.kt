package com.example.homework_98515

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

private const val TAG = "MSViewModel"
class MSViewModel : ViewModel() {
    private val _movies = getMoviesSeries().toMutableStateList()
    val movie: List<MS>
        get() = _movies

    fun remove(item: MS) {
        Log.d(TAG, "remove: $item")
        _movies.remove(item)
        Log.d(TAG, "remove: $_movies")
    }

    fun add(item: MS) {
        Log.d(TAG, "add: $item")
        _movies.add(item)
        Log.d(TAG, "add: $_movies")
    }

}
fun getMoviesSeries() = List(3) { i -> MS(i, "Movie # $i") }


