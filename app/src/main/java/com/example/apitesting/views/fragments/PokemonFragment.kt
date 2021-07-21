package com.example.apitesting.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apitesting.R
import com.example.apitesting.viewmodels.PokemonViewModel
import com.squareup.picasso.Picasso

class PokemonFragment: Fragment(R.layout.fragment_pokemon) {
    private lateinit var pokemonName: TextView
    private lateinit var viewModel: PokemonViewModel
    private lateinit var pokemonImage: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonName = view.findViewById(R.id.pokemon_name_textView)
        pokemonImage = view.findViewById(R.id.pokemon_ImageView)
        button = view.findViewById(R.id.button)

        button.setOnClickListener{
            val randomNumber = viewModel.roll()
            viewModel.fetchPokemonData(randomNumber)
            viewModel.pokemonLiveData.observe(viewLifecycleOwner){
                //pintamos la información
                pokemonName.text = it.name
                Picasso.get()
                    .load(it.sprites.front_default)
                    .resize(500,500)
                    .into(pokemonImage)
            }
        }


    }


}

