package com.pigllet.themovieapp.domain

import java.io.Serializable

data class Movie(
    var user_id: Long,
    var release_date: String,
    var display_name: String,
    var profile_image: String,
    var vote_average: String
) : Serializable