package com.pigllet.themovieapp.domain

import java.io.Serializable

data class Movie(
    var id: Long,
    var release_date: String,
    var title: String,
    var poster_path: String
) : Serializable