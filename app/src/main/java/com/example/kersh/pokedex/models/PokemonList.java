package com.example.kersh.pokedex.models;

import java.util.ArrayList;

/**
 * Created by kersh on 2016/09/13.
 */

public class PokemonList {
    private int count;

    private ArrayList<Pokemon> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}
