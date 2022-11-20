package com.example.revchap5


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.revchap5.databinding.MovieItemBinding
import com.example.revchap5.model.Movie

class MovieAdapter(var listMovie: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(var binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =MovieItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cvMovie.setOnClickListener {
            var bundle = Bundle()
            bundle.putSerializable("detail",listMovie[position])
            it.findNavController().navigate(R.id.action_homeFragment2_to_detailFragment, bundle)

        }
        holder.binding.movieTitle.text = listMovie[position].title
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+listMovie[position].poster)
            .into(holder.binding.moviePoster)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }
}