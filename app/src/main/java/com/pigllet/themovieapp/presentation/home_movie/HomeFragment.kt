package com.pigllet.themovieapp.presentation.home_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.pigllet.themovieapp.R
import com.pigllet.themovieapp.databinding.FragmentHomeBinding
import com.pigllet.themovieapp.domain.models.ResultsItem
import com.pigllet.themovieapp.presentation.MainActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModel: HomeViewModel

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val movieAdapter: MovieListAdapter by lazy {
        MovieListAdapter(movieClick)
    }

    val movieClick = object : MovieListAdapter.MovieClick {
        override fun onMovieClick(movie: ResultsItem) {
            detailMovie(movie)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_home,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.listMovie.observe(this, {
            movieAdapter.setListUser(it)
        })
        viewModel.loadMovieList()
    }

    fun setUpAdapter() {
        binding.listMovie.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    fun detailMovie(movie: ResultsItem) {
        (activity as MainActivity).showDetailMovie(movie)
    }

}