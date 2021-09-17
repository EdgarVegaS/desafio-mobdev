package com.rickandmorty.models.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CharacterResponse {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episodeCount;
    OriginResponse origin;
    
}
