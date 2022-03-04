package com.reactivo.app.controller;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.usecase.CafeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//TODO: Agregar logica para usar Bases de Datos
@RestController
@RequestMapping("/cafe")
@AllArgsConstructor
public class CafeController {

    //private final CafeRepository cafeRepository
    private final CafeUseCase cafeUseCase;

    //Usaremos Mono para procesar de forma reactiva, un solo objeto
    @GetMapping("/{id}")
    public Mono<Cafe> getCafeById(@PathVariable String id){
        return cafeUseCase.getById(id);
    }

    @GetMapping("/costoCafe/{id}")
    public Mono<String> getCostoCafeById(@PathVariable String id){
        return cafeUseCase.getCostoCafeById(id);
    }

    //Usaremos Flux para procesar de forma reactiva, uno o mas objetos
    @GetMapping("/verCafes")
    public Flux<Cafe> getCafes() {
        return cafeUseCase.getCafes();
    }
}
