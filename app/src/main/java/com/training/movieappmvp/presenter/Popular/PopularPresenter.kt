package com.training.movieappmvp.presenter.Popular

import com.training.movieappmvp.model.OperationalCallBackPopular
import com.training.movieappmvp.model.PopularMovie.PopularResponse
import com.training.movieappmvp.model.VolleyHandler

class PopularPresenter(
    private val volleyHandler:VolleyHandler,
            private val popularView: MVPPopular.PopularView
): MVPPopular.PopularPresenter {
    override fun fetchPopularMovieData() {
        popularView.onLoadPopular(true)
        volleyHandler.makeApiCallPopular(object : OperationalCallBackPopular{
            override fun onSuccessPopular(popularResponse: PopularResponse) {
                popularView.onLoadPopular(false)
                popularView.setResultPopular(popularResponse)
            }

            override fun onFailurePopular(message: String) {
                popularView.onLoadPopular(false)
                popularView.showErrorPopular(message)
            }
        })
    }
}