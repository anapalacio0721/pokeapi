package com.example.pokeapi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokeapi.service.PokeApiService;

@RestController
@RequestMapping( "/pokeapi" )
public class PokeApiController {
    private final PokeApiService pokeapiservice;
    public PokeApiController( @Autowired PokeApiService pokeapiservice )
    {
        this.pokeapiservice = pokeapiservice;
    } 
    @GetMapping
    public ResponseEntity<PokeApi> mostrarPokemon(){
        try {
            return ResponseEntity.ok(pokeapiservice.consultarPokeApi());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
