package com.rickandmorty.clients;

import static com.rickandmorty.utils.MethodsUtils.getValueNode;

import com.fasterxml.jackson.databind.JsonNode;
import com.rickandmorty.models.dto.CharacterDto;
import com.rickandmorty.models.dto.OriginDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestClient {

    @Autowired
    RestTemplate restConnection;
    
    public CharacterDto getCharacterById(String id){
        String url = String.format("https://rickandmortyapi.com/api/character/%s", id);
        try {
            JsonNode response = restConnection.getForEntity(url ,JsonNode.class).getBody();
            CharacterDto characterDto = new CharacterDto();
            characterDto.setId(Integer.parseInt(id));
            characterDto.setName(getValueNode(response, "name"));
            characterDto.setStatus(getValueNode(response, "status"));
            characterDto.setSpecies(getValueNode(response, "species"));
            characterDto.setType(getValueNode(response, "type"));
            characterDto.setEpisodeCount(response.get("episode").size());

            JsonNode nodeOrigin = response.get("origin");
            String urlOrigin = getValueNode(nodeOrigin, "url");
            OriginDto originDto = getOriginByUrl(urlOrigin);

            characterDto.setOrigin(originDto);

            return characterDto;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public OriginDto getOriginByUrl(String urlString){
        try {
            JsonNode response = restConnection.getForEntity(urlString ,JsonNode.class).getBody();
            OriginDto originDto = new OriginDto();
            originDto.setName(getValueNode(response, "name"));
            originDto.setUrl(getValueNode(response, "url"));
            originDto.setDimension(getValueNode(response, "dimension"));
            JsonNode residentsNode = response.get("residents");
            for (JsonNode jsonNode : residentsNode) {
                originDto.getResidents().add(jsonNode.asText());
            }
            return originDto;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
