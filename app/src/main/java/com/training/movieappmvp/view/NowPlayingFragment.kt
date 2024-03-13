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
import com.training.movieappmvp.model.Constants
import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse
import com.training.movieappmvp.model.VolleyHandler
import com.training.movieappmvp.presenter.Nowplaying.MVPNowplaying
import com.training.movieappmvp.presenter.Nowplaying.NowPlayingPresenter
import com.training.movieappmvp.presenter.Upcoming.UpcomingPresenter


class NowPlayingFragment : Fragment(), MVPNowplaying.NowplayingView {
   private lateinit var binding:FragmentNowPlayingBinding
   private lateinit var presenter: NowPlayingPresenter
   private lateinit var adapter: MovieRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentNowPlayingBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPresenterNowplaying()
        initViews()
        val recycler=binding.recyclerview
        val spanCount=1
        recycler.layoutManager=GridLayoutManager(requireContext(),spanCount,LinearLayoutManager.VERTICAL,false)
        // Inflate the layout for this fragment
    }
    private fun initViews(){
        presenter.fetchNowplayingMovieData()
    }
    private fun initPresenterNowplaying(){
        presenter=NowPlayingPresenter(VolleyHandler(requireContext()),this)
    }

    override fun setResultNowplaying(nowPlayingResponse: NowPlayingResponse) {
        val yourList=ArrayList<DetailsMovie>()
        val list=nowPlayingResponse.results
        for(i in list.indices){
            var url= "${Constants.BASE_URL_IMAGE.replace("{movie_id}",list[i].poster_path)}"
            yourList.add(DetailsMovie(url,list[i].title.toString(),list[i].popularity.toString(),list[i].original_language.toString()))

        }
        val adapter = MovieRecyclerAdapter( yourList)
        binding.recyclerview.adapter = adapter
    }

    override fun onLoadNowplaying(isLoading: Boolean) {
        if(isLoading){
            binding.progressNowplaying.visibility = View.VISIBLE
        }else{
            binding.progressNowplaying.visibility = View.GONE
        }
    }

    override fun showErrorNowplaying(message: String) {

    }
    }



