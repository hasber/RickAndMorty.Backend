package com.rickandmory.backend.client;

import com.rickandmory.backend.core.characters.domain.Root;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RickAndMortyClientImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RickAndMortyClientImpl rickAndMortyClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Value("${URL_BASE_API}")
    private String URL;

    @Test
    void testGetCharacters() {
        Root expectedRoot = new Root();
        ResponseEntity<Root> responseEntity = new ResponseEntity<>(expectedRoot, HttpStatus.OK);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Root.class)))
                .thenReturn(responseEntity);

        Root result = rickAndMortyClient.GetCharacters();

        verify(restTemplate).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Root.class));
        assertEquals(expectedRoot, result);
    }

    @Test
    void testGetByGeder() {
        Root expectedRoot = new Root();
        ResponseEntity<Root> responseEntity = new ResponseEntity<>(expectedRoot, HttpStatus.OK);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Root.class)))
                .thenReturn(responseEntity);
        Root result = rickAndMortyClient.getByGeder("male");
        verify(restTemplate).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Root.class));
        assertEquals(expectedRoot, result);
    }

    @Test
    void testGetBySpecie() {
        Root expectedRoot = new Root();
        ResponseEntity<Root> responseEntity = new ResponseEntity<>(expectedRoot, HttpStatus.OK);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Root.class)))
                .thenReturn(responseEntity);
        Root result = rickAndMortyClient.getBySpecie("human");
        verify(restTemplate).exchange(anyString(), eq(HttpMethod.GET), any(HttpEntity.class), eq(Root.class));
        assertEquals(expectedRoot, result);
    }
}