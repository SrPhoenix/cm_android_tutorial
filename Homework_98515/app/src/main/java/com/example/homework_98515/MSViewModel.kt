package com.example.homework_98515

import androidx.lifecycle.ViewModel

class MSViewModel : ViewModel() {
    private val _movies = getMoviesSeries().toMutableList()
    val movie: List<MS>
        get() = _movies

    fun remove(item: MS) {
        _movies.remove(item)
    }

}
fun getMoviesSeries() = List(3) { i -> MS(i, "Movie # $i") }


