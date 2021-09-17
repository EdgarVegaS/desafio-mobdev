package com.rickandmorty.models.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class CharacterDto {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episodeCount;
    private OriginDto origin;
    
}
