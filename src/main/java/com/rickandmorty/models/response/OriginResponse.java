package com.rickandmorty.models.response;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class OriginResponse {
    
    private String name;
    private String url;
    private String dimension;
    private List<String> residents = new ArrayList<>();

}
