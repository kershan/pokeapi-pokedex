package com.example.kersh.pokedex.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.kersh.pokedex.R;
import com.example.kersh.pokedex.models.Pokemon;
import com.example.kersh.pokedex.models.PokemonList;
import com.example.kersh.pokedex.services.PokedexService;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    PokedexService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup RetroFit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(PokedexService.class);


        //Start get Pokemon task
        GetPokemonTask task = new GetPokemonTask();
        task.execute();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private class GetPokemonTask extends AsyncTask<Void, Void, ArrayList<Pokemon>> {

        @Override
        protected ArrayList<Pokemon> doInBackground(Void... params) {

            try {
                PokemonList list = mService.listPokemon().execute().body();
                return list.getResults();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Pokemon> pokemons) {
            super.onPostExecute(pokemons);

            //Display data if successful
            if (pokemons != null) {
                for (Pokemon pokemon : pokemons) {
                    Toast.makeText(MainActivity.this, "Response: " + pokemon.getName(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "No Pokemon Found :O", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
