package com.rickandmorty.controllers;

import com.rickandmorty.clients.RestClient;
import com.rickandmorty.models.dto.CharacterDto;
import com.rickandmorty.models.response.CharacterResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rickandmorty")
public class MainController {

    @Autowired
    RestClient restClient;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/{id}")
    public CharacterResponse getCharacterById(@PathVariable String id){

        CharacterDto characterDto = restClient.getCharacterById(id);
        CharacterResponse response = mapper.map(characterDto, CharacterResponse.class);
        return response;
    }
    
}
