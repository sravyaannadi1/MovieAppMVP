package com.training.movieappmvp.presenter.Popular

import com.training.movieappmvp.model.PopularMovie.PopularResponse

interface MVPPopular {
    interface PopularPresenter{
        fun fetchPopularMovieData()
    }
    interface PopularView{
        fun setResultPopular(popularResponse: PopularResponse)
        fun onLoadPopular(isLoading: Boolean)
        fun showErrorPopular(message: String)
    }
}