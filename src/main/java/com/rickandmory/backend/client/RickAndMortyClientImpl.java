package com.rickandmory.backend.client;

import com.rickandmory.backend.core.characters.domain.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class RickAndMortyClientImpl implements RickAndMortyClient {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${URL_BASE_API}")
    private String URL;

    @Override
    public Root GetCharacters() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            String urlBase = URL + "/api/character";
            ResponseEntity<Root> responseEntity = restTemplate.exchange(urlBase, HttpMethod.GET, requestEntity, Root.class);
            if (HttpStatus.OK != responseEntity.getStatusCode()) {
                throw new SecurityException("Error al obtener las listas");
            }
            log.info("Finish GetCharacters {}", responseEntity);
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Error GetCharacters {}" + e.getMessage());
            throw new SecurityException("Error consulta API characters " + e.getMessage());
        }
    }

    @Override
    public Root getByGeder(String gender) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            String urlBase = URL + "/api/character";
            UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(urlBase)
                    .queryParam("gender", gender);
            ResponseEntity<Root> responseEntity = restTemplate.exchange(url.toUriString(), HttpMethod.GET, requestEntity, Root.class);
            if (HttpStatus.OK != responseEntity.getStatusCode()) {
                throw new SecurityException("Error al obtener las listas");
            }
            log.info("Finish getByGeder {}", responseEntity);
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Error getByGeder {}" + e.getMessage());
            throw new SecurityException("Error consulta API getByGeder " + e.getMessage());
        }
    }

    @Override
    public Root getBySpecie(String specie) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<?> requestEntity = new HttpEntity<>(headers);
            String urlBase = URL + "/api/character";
            UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(urlBase)
                    .queryParam("species", specie);
            ResponseEntity<Root> responseEntity = restTemplate.exchange(url.toUriString(), HttpMethod.GET, requestEntity, Root.class);
            if (HttpStatus.OK != responseEntity.getStatusCode()) {
                throw new SecurityException("Error al obtener las listas");
            }
            log.info("Finish getByGeder {}", responseEntity);
            return responseEntity.getBody();
        } catch (Exception e) {
            log.error("Error saveUnemployed {}" + e.getMessage());
            throw new SecurityException("Error consulta API getByGeder " + e.getMessage());
        }
    }
}
