package com.training.movieappmvp.presenter.Upcoming

import com.training.movieappmvp.model.UpcomingMovie.UpcomingMovieResponse

interface MVPUpcoming {
    interface UpcomingPresenter{
        fun fetchUpcomingMovieData()
    }
    interface UpcomingView{
        fun setResultUpcoming(upcomingMovieResponse: UpcomingMovieResponse)
        fun onLoadUpcoming(isLoading: Boolean)
        fun showErrorUpcoming(message: String)
    }
}