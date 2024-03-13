package com.training.movieappmvp.model.UpcomingMovie

data class UpcomingMovieResponse(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)