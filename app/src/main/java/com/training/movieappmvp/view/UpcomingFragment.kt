package com.training.movieappmvp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.training.movieappmvp.R
import com.training.movieappmvp.databinding.FragmentPopularBinding
import com.training.movieappmvp.databinding.FragmentUpcomingBinding
import com.training.movieappmvp.model.Constants
import com.training.movieappmvp.model.PopularMovie.PopularResponse
import com.training.movieappmvp.model.UpcomingMovie.UpcomingMovieResponse
import com.training.movieappmvp.model.VolleyHandler
import com.training.movieappmvp.presenter.Popular.MVPPopular
import com.training.movieappmvp.presenter.Popular.PopularPresenter
import com.training.movieappmvp.presenter.Upcoming.MVPUpcoming
import com.training.movieappmvp.presenter.Upcoming.UpcomingPresenter

class UpcomingFragment : Fragment(), MVPUpcoming.UpcomingView {
    private lateinit var binding: FragmentUpcomingBinding
    private lateinit var presenter: UpcomingPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentUpcomingBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler=binding.recyclerview
        val spanCount=1
        recycler.layoutManager=
            GridLayoutManager(requireContext(),spanCount, LinearLayoutManager.VERTICAL,false)
        initPresenterUpcoming()
        initViews()
    }
    private fun initViews(){
        presenter.fetchUpcomingMovieData()
    }
    private fun initPresenterUpcoming(){
        presenter= UpcomingPresenter(VolleyHandler(requireContext()),this)
    }

    override fun setResultUpcoming(upcomingMovieResponse: UpcomingMovieResponse) {
        val yourList=ArrayList<DetailsMovie>()
        val list=upcomingMovieResponse.results
        for(i in list.indices){
            var url= "${Constants.BASE_URL_IMAGE.replace("{movie_id}",list[i].poster_path)}"
            yourList.add(DetailsMovie(url,list[i].title,list[i].popularity.toString(),list[i].original_language))

        }
        val adapter = MovieRecyclerAdapter( yourList)
        binding.recyclerview.adapter = adapter
    }

    override fun onLoadUpcoming(isLoading: Boolean) {
        if(isLoading){
            binding.progressUpcoming.visibility = View.VISIBLE
        }else{
            binding.progressUpcoming.visibility = View.GONE
        }
    }

    override fun showErrorUpcoming(message: String) {

    }
}



