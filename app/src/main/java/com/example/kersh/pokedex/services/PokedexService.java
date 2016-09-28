package com.example.kersh.pokedex.services;

import com.example.kersh.pokedex.models.PokemonList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kersh on 2016/09/13.
 */

public interface PokedexService {
    @GET("pokemon")
    Call<PokemonList> listPokemon();
}
