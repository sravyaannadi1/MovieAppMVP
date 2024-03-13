package com.training.movieappmvp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.movieappmvp.R
import com.training.movieappmvp.databinding.FragmentNowPlayingBinding
import com.training.movieappmvp.databinding.FragmentPopularBinding
import com.training.movieappmvp.model.Constants
import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse
import com.training.movieappmvp.model.PopularMovie.PopularResponse
import com.training.movieappmvp.model.VolleyHandler
import com.training.movieappmvp.presenter.Nowplaying.MVPNowplaying
import com.training.movieappmvp.presenter.Nowplaying.NowPlayingPresenter
import com.training.movieappmvp.presenter.Popular.MVPPopular
import com.training.movieappmvp.presenter.Popular.PopularPresenter


class PopularFragment : Fragment(), MVPPopular.PopularView {
    private lateinit var binding: FragmentPopularBinding
    private lateinit var presenter: PopularPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentPopularBinding.inflate(layoutInflater)


        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenterPopular()
        initViews()
        val recycler=binding.recyclerview
        val spanCount=1
        recycler.layoutManager=
            GridLayoutManager(requireContext(),spanCount, LinearLayoutManager.VERTICAL,false)
    }
    private fun initViews(){
        presenter.fetchPopularMovieData()
    }
    private fun initPresenterPopular(){
        presenter= PopularPresenter(VolleyHandler(requireContext()),this)
    }

    override fun setResultPopular(popularResponse: PopularResponse) {
        val yourList=ArrayList<DetailsMovie>()
        val list=popularResponse.results
        for(i in list.indices){
            //var url= "${Constants.BASE_URL_IMAGE.replace("{movie_id}",list[i].poster_path)}"
            yourList.add(DetailsMovie(list[i].poster_path,list[i].title,list[i].popularity.toString(),list[i].original_language))

        }
        val adapter = MovieRecyclerAdapter(yourList)
        binding.recyclerview.adapter = adapter
    }

    override fun onLoadPopular(isLoading: Boolean) {
        if(isLoading){
            binding.progresspopular.visibility = View.VISIBLE
        }else{
            binding.progresspopular.visibility = View.GONE
        }
    }

    override fun showErrorPopular(message: String) {

    }
}



