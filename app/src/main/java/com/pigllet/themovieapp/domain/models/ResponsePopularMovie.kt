package com.pigllet.themovieapp.domain.models

import com.pigllet.themovieapp.domain.Movie

data class ResponsePopularMovie(var movies: List<ResultsItem>)