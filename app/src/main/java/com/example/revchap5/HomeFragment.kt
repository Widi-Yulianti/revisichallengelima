package com.example.revchap5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revchap5.databinding.FragmentHomeBinding
import com.example.revchap5.model.Movie
import com.example.revchap5.model.MovieViewModel

class HomeFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    fun showDataMoviePopoular() {
        val viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.callApiPopularMovie{movies: List<Movie> ->
            binding.rvMovie1.adapter = MovieAdapter(movies)
        }
        binding.rvMovie1.layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvMovie1.setHasFixedSize(true)
    }

}