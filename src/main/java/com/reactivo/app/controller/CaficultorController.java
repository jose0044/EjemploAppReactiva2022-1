package com.reactivo.app.controller;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.modelos.Caficultor;
import com.reactivo.app.modelos.Empaque;
import com.reactivo.app.modelos.Saco;
import com.reactivo.app.usecase.CaficultorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/caficultor")
@AllArgsConstructor
public class CaficultorController {

    private final CaficultorUseCase caficultorUseCase;

    @GetMapping("/{id}")
    public Mono<Caficultor> getCaficultorById(@PathVariable String id){
        return caficultorUseCase.getCaficultorById(id);
    }

    @GetMapping("/verCaficultores")
    public Flux<Caficultor> getCaficultores(){
        return caficultorUseCase.getCaficultores();
    }
}
