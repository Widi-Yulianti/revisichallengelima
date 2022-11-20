package com.example.revchap5.services

import com.example.revchap5.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=92a295eefed19d96bd0d895cfae59ef5")
    fun getMovieList(): Call<MovieResponse>
}