package com.training.movieappmvp.model

import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse
import com.training.movieappmvp.model.UpcomingMovie.UpcomingMovieResponse

interface OperationalCallBackUpcoming {
    fun onSuccessUpcoming(upcomingMovieResponse: UpcomingMovieResponse)
    fun onFailureUpcoming(message:String)
}