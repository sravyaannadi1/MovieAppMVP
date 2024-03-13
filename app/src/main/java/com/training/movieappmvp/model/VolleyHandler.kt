package com.training.movieappmvp.model

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.training.movieappmvp.model.Constants.BASE_URL_NOWPLAYING
import com.training.movieappmvp.model.Constants.BASE_URL_Popular
import com.training.movieappmvp.model.Constants.BASE_URL_Upcoming
import com.training.movieappmvp.model.NowPlaying.NowPlayingResponse
import com.training.movieappmvp.model.PopularMovie.PopularResponse
import com.training.movieappmvp.model.UpcomingMovie.UpcomingMovieResponse

class VolleyHandler (private val context: Context){
    private val requestQueue by lazy{ Volley.newRequestQueue(context)}
    fun makeApiCallNowplaying(callBackNow: OperationalCallBackNow){
        val stringRequest= StringRequest(Request.Method.GET,BASE_URL_NOWPLAYING,{
            val typeToken=object :TypeToken<NowPlayingResponse>(){}
            val response=Gson().fromJson(it,typeToken)
            Log.i("tag","$it")
            Log.i("tag","${response.total_pages}")

                Log.i("tag","${response.total_pages}")
                callBackNow.onSuccessNowplaying(response)


             }
            ,{
                Log.i("tag","${it.toString()}")
                callBackNow.onFailureNowplaying("Error")
            })
        requestQueue.add(stringRequest)
    }
    fun makeApiCallUpcoming(callBackUpcoming: OperationalCallBackUpcoming){
        val stringRequest= StringRequest(Request.Method.GET,BASE_URL_Upcoming,{
            val typeToken=object :TypeToken<UpcomingMovieResponse>(){}
            val response=Gson().fromJson(it,typeToken)
            Log.i("tag","$it")
            Log.i("tag","${response.total_pages}")

                Log.i("tag","${response.total_pages}")
                callBackUpcoming.onSuccessUpcoming(response)
             }
            ,{
                Log.i("tag","${it.toString()}")
                callBackUpcoming.onFailureUpcoming("${it.message}")
            })
        requestQueue.add(stringRequest)
    }
    fun makeApiCallPopular(callBackPopular: OperationalCallBackPopular){
        val stringRequest= StringRequest(Request.Method.GET,BASE_URL_Popular,{
            val typeToken=object :TypeToken<PopularResponse>(){}
            val response=Gson().fromJson(it,typeToken)
            Log.i("tag","$it")
            Log.i("tag","${response.total_pages}")

                Log.i("tag","${response.total_pages}")
                callBackPopular.onSuccessPopular(response)
             }
            ,{
                Log.i("tag","${it.toString()}")
                callBackPopular.onFailurePopular("Error")
            })
        requestQueue.add(stringRequest)
    }


}