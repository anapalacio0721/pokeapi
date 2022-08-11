package com.example.pokeapi.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.example.pokeapi.controller.PokeApi;
import com.example.pokeapi.service.PokeApiService;
import com.google.gson.Gson;

@Service
public class PokeApiServiceImpl implements PokeApiService {

    
    @Override  //consumo de una api
    public PokeApi consultarPokeApi() throws IOException {
        URL url = new URL("https://pokeapi.co/api/v2/pokemon");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Gson g = new Gson();
            PokeApi pokeapi = g.fromJson(response.toString(), PokeApi.class); // declaro la variable pokeapi de tipo objeto PokeApi
            return pokeapi; 
        }
        return null;
    }
    
}


