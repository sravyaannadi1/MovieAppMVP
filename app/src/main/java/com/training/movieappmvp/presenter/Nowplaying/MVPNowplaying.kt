package com.training.movieappmvp.presenter.Nowplaying

import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse
import com.training.movieappmvp.model.PopularMovie.PopularResponse

interface MVPNowplaying {
    interface NowplayingPresenter{
        fun fetchNowplayingMovieData()
    }
    interface NowplayingView{
        fun setResultNowplaying(nowPlayingResponse: NowPlayingResponse)
        fun onLoadNowplaying(isLoading: Boolean)
        fun showErrorNowplaying(message: String)
    }
}