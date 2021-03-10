package com.pigllet.themovieapp.presentation.detail_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.pigllet.themovieapp.databinding.FragmentDetailMovieBinding
import com.pigllet.themovieapp.domain.models.ResultsItem
import com.pigllet.themovieapp.utils.IMAGE_URL_API
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import javax.inject.Inject

class DetailMovieFragment : Fragment() {

    @Inject
    lateinit var viewModel: DetailMovieViewModel

    private lateinit var binding: FragmentDetailMovieBinding


    companion object {
        private const val KEY_MOVIE = "KEY_MOVIE"
        fun newInstance(movie: ResultsItem): DetailMovieFragment {
            val bundle = Bundle()
            bundle.putSerializable(KEY_MOVIE, movie)
            val fragment = DetailMovieFragment().apply {
                arguments = bundle
            }
            return fragment
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.mToolbar.setTitle("Movie Details")
        binding.imgBack.setOnClickListener(View.OnClickListener {
            fragmentManager?.popBackStack()
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            var movie = it.getSerializable(KEY_MOVIE) as ResultsItem
            movie?.let {
                binding.txtTitle.setText(movie.title)
                binding.txtContent.setText(movie.overview)
                binding.dateTime.setText(movie.releaseDate)
                Glide.with(requireContext()).load(IMAGE_URL_API + movie.backdropPath)
                    .into(imgAvatar)
            }
        }
    }


}