package com.rickandmorty.models.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class OriginDto {

    private String name;
    private String url;
    private String dimension;
    private List<String> residents = new ArrayList<>();
    
}