package com.example.revchap5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.revchap5.databinding.FragmentDetailBinding
import com.example.revchap5.model.Movie

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments?.getSerializable("detail") != null) {
            var getDetailMovie = arguments?.getSerializable("detail") as Movie
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + getDetailMovie.poster)
                .into(binding.ivMoviePoster)
            binding.titleText.text = getDetailMovie.title
            binding.tvOverview.text = getDetailMovie.overview
        }

    }
}