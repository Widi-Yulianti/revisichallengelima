package com.example.revchap5.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApiService {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org"
        val instance : MovieApiInterface by lazy {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Companion.BASE_URL)
                .build()

            retrofit.create(MovieApiInterface::class.java)
        }
    }
}