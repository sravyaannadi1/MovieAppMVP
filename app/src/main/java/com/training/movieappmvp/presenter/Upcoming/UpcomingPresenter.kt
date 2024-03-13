package com.training.movieappmvp.presenter.Upcoming

import com.training.movieappmvp.model.OperationalCallBackPopular
import com.training.movieappmvp.model.OperationalCallBackUpcoming
import com.training.movieappmvp.model.PopularMovie.PopularResponse
import com.training.movieappmvp.model.UpcomingMovie.UpcomingMovieResponse
import com.training.movieappmvp.model.VolleyHandler
import com.training.movieappmvp.presenter.Popular.MVPPopular

class UpcomingPresenter(
    private val volleyHandler: VolleyHandler,
    private val upcomingView:MVPUpcoming.UpcomingView
): MVPUpcoming.UpcomingPresenter {
    override fun fetchUpcomingMovieData(){
        upcomingView.onLoadUpcoming(true)
        volleyHandler.makeApiCallUpcoming(object : OperationalCallBackUpcoming {
            override fun onSuccessUpcoming(upcomingMovieResponse: UpcomingMovieResponse) {
                upcomingView.onLoadUpcoming(false)
                upcomingView.setResultUpcoming(upcomingMovieResponse)
            }

            override fun onFailureUpcoming(message: String) {
                upcomingView.onLoadUpcoming(false)
                upcomingView.showErrorUpcoming(message)
            }
        })
    }
}