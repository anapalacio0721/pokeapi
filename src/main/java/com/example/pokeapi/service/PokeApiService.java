package com.example.pokeapi.service;

import java.io.IOException;

import com.example.pokeapi.controller.PokeApi;

public interface PokeApiService {
    PokeApi consultarPokeApi() throws IOException;
}
