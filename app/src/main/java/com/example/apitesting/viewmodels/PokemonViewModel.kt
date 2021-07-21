package com.example.apitesting.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apitesting.network.RetrofitProvider
import com.example.apitesting.network.models.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModel: ViewModel() {
    private val retrofitProvider = RetrofitProvider()
    //privado
    private val _pokemonLiveData = MutableLiveData<PokemonResponse>()
    //público
    val pokemonLiveData: LiveData<PokemonResponse> = _pokemonLiveData

    fun fetchPokemonData(id: Int){
        retrofitProvider.getAPIService()
            .getPokemonDetails(id)
            .enqueue(object: Callback<PokemonResponse>{
                override fun onResponse(
                    call: Call<PokemonResponse>,
                    response: Response<PokemonResponse>
                ) {
                    if (response.isSuccessful){
                        _pokemonLiveData.postValue(response.body())
                    }else {
                        //servidor falla, por varias razones, por ejemplo no se armo bien el request
                    }
                }

                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    //servidor falla, no se pudo conectar
                    val a = ""
                }

            })


    }
    fun roll(): Int {
        val randomNumber = (1..1118).random()
        return randomNumber
    }
}