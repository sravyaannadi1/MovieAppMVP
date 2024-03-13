package com.training.movieappmvp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.training.movieappmvp.databinding.ItemLayoutMovieBinding
import com.training.movieappmvp.model.Constants

class MovieRecyclerAdapter( private val items: ArrayList<DetailsMovie>):
RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(private val binding: ItemLayoutMovieBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: DetailsMovie){
            val imageUrl = "${Constants.BASE_URL_IMAGE.replace("{movie_id}",item.posterPath)}"

            // Load image using Picasso
            Picasso.get().load(imageUrl).into(binding.imageView2)
            binding.title.text=item.title
            binding.rating.text=item.popularity
            binding.language.text=item.language

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemLayoutMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int = items.size
}