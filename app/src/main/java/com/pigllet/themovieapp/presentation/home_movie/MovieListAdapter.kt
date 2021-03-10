package com.pigllet.themovieapp.presentation.home_movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pigllet.themovieapp.databinding.ItemMovieBinding
import com.pigllet.themovieapp.domain.Movie
import com.pigllet.themovieapp.domain.models.ResultsItem

class MovieListAdapter(val listener: MovieClick) :
    RecyclerView.Adapter<MovieListAdapter.MovieHolder>() {

    private var listMovie = mutableListOf<ResultsItem>()

    fun setListUser(movies: List<ResultsItem>) {
        listMovie.clear()
        listMovie.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(listMovie.get(position))
        holder.binding.root.setOnClickListener { view ->
            listener.onMovieClick(listMovie.get(position))
        }
    }

    class MovieHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: ResultsItem) {
            binding.viewModel = movie
            binding.executePendingBindings()
        }
    }


    interface MovieClick {
        fun onMovieClick(movie: ResultsItem){}
    }
}
