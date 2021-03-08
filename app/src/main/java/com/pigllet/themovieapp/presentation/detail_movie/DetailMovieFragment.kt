package com.pigllet.themovieapp.presentation.detail_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pigllet.themovieapp.R
import com.pigllet.themovieapp.domain.Movie

class DetailMovieFragment : Fragment() {

    companion object {
        fun newInstance(movie: Movie) = DetailMovieFragment()
    }

    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ///viewModel = ViewModelProvider(this).get(DetailMovieViewModel::class.java)
        // TODO: Use the ViewModel
    }

}