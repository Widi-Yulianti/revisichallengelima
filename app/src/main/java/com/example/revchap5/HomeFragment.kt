package com.example.revchap5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.revchap5.databinding.FragmentHomeBinding
import com.example.revchap5.model.Movie
import com.example.revchap5.model.MovieViewModel

class HomeFragment : Fragment() {
    lateinit var sharedPrefs : SharedPreferences

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

    companion object{
        const val USERNAME = "username"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)
        val user = sharedPrefs.getString(USERNAME, "")
        binding.tvSayHello.text = "Hi $user!"

        showDataMoviePopoular()

        binding.btnProfil.setOnClickListener {
            this.findNavController().navigate(R.id.action_homeFragment2_to_profileFragment)
        }
    }


    fun showDataMoviePopoular() {
        val viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        viewModel.callApiPopularMovie{movies: List<Movie> ->
            binding.rvMoviesList.adapter = MovieAdapter(movies)
        }
        binding.rvMoviesList.layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.HORIZONTAL,false)
        binding.rvMoviesList.setHasFixedSize(true)
    }

}