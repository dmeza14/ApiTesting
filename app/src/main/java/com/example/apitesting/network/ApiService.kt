package com.example.apitesting.network

import com.example.apitesting.network.models.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

   /* @GET("pokemon")
    fun getPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Call<PokemonResponse> */

    @GET("pokemon/{id}")
    fun getPokemonDetails(
        @Path("id") id: Int
    ): Call<PokemonResponse>


}