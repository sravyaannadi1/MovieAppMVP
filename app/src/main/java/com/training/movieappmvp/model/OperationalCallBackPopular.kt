package com.training.movieappmvp.model

import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse
import com.training.movieappmvp.model.PopularMovie.PopularResponse

interface OperationalCallBackPopular {
    fun onSuccessPopular(popularResponse: PopularResponse)
    fun onFailurePopular(message:String)
}