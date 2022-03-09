package com.reactivo.app.controller;

import com.reactivo.app.modelos.Saco;
import com.reactivo.app.usecase.SacoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/saco")
@AllArgsConstructor
public class SacoController {

    private final SacoUseCase sacoUseCase;

    @GetMapping("/verSacos")
    public Flux<Saco> getCafes(){
        return sacoUseCase.getCafes();
    }
}
