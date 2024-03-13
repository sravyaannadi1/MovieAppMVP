package com.training.movieappmvp.presenter.Nowplaying

import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse
import com.training.movieappmvp.model.OperationalCallBackNow
import com.training.movieappmvp.model.OperationalCallBackPopular
import com.training.movieappmvp.model.PopularMovie.PopularResponse
import com.training.movieappmvp.model.VolleyHandler
import com.training.movieappmvp.presenter.Popular.MVPPopular

class NowPlayingPresenter(
    private val volleyHandler: VolleyHandler,
    private val nowplayingView: MVPNowplaying.NowplayingView
): MVPNowplaying.NowplayingPresenter {
    override fun fetchNowplayingMovieData() {
        nowplayingView.onLoadNowplaying(true)
        volleyHandler.makeApiCallNowplaying(object : OperationalCallBackNow {
            override fun onSuccessNowplaying(nowPlayingResponse: NowPlayingResponse ) {
                nowplayingView.onLoadNowplaying(false)
                nowplayingView.setResultNowplaying(nowPlayingResponse)
            }

            override fun onFailureNowplaying(message: String) {
                nowplayingView.onLoadNowplaying(false)
               nowplayingView.showErrorNowplaying(message)
            }
        })
    }
}