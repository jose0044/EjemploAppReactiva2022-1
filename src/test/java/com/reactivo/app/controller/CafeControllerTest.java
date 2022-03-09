package com.reactivo.app.controller;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.usecase.CafeUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CafeControllerTest {

    @MockBean
    CafeUseCase cafeUseCase;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getCafeById() {

        /*TODO: Se agrega el Mockito.when para asegurar que cafeUseCase
        retorne un Cafe cuando se llama un getCafeById

        Mockito.when(cafeUseCase.getCafeByIdMono(id)).thenReturn(cafePrueba);
         */
        webTestClient.get()
                .uri("/cafe/{id}")
                .header(HttpHeaders.ACCEPT, "application/json")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cafe.class);


        /*TODO: Se agrega el Mockito.verify para validar que desde cafeUseCase
        se llamo el metodo getCafeById una vez:

        Mockito.verify(cafeUseCase, Mockito.times(1)).getCafeByIdMono();
         */
    }
}