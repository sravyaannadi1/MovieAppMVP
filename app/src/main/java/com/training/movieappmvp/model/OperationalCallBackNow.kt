package com.training.movieappmvp.model

import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse

interface OperationalCallBackNow {
    fun onSuccessNowplaying(nowPlayingResponse: NowPlayingResponse)
    fun onFailureNowplaying(message:String)
}