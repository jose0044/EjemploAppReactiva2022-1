package com.reactivo.app.controller;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.modelos.Caficultor;
import com.reactivo.app.modelos.Empaque;
import com.reactivo.app.modelos.Saco;
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

@RestController
@RequestMapping("/caficultor")
@AllArgsConstructor
public class CaficultorController {

    @GetMapping("/{id}")
    public Mono<Caficultor> getCaficultorById(@PathVariable String id){


        Caficultor caficultorPrueba = new Caficultor("32456129", "Francisco Jimenez",
                "Fredonia", cafesPredeterminados());

        return Mono.just(caficultorPrueba);
    }

    @GetMapping("/verCaficultores")
    public Flux<Caficultor> getCaficultores(){
        Caficultor caficultorPrueba = new Caficultor("32456129", "Francisco Jimenez",
                "Fredonia", cafesPredeterminados());
        Caficultor caficultorPrueba2 = new Caficultor("8544689", "Yolanda Perez",
                "Armenia", cafesPredeterminados());
        Caficultor caficultorPrueba3 = new Caficultor("87456189", "Leopoldo Castro",
                "Manizales", cafesPredeterminados());

        return Flux.merge(Mono.just(caficultorPrueba), Mono.just(caficultorPrueba2), Mono.just(caficultorPrueba3));
    }

    @GetMapping("/verSacos/{nombreCaficultor}")
    public Flux<Caficultor> getSacosCaficultor(@PathVariable String nombreCaficultor){
        Caficultor caficultorPrueba = new Caficultor("32456129", "Francisco Jimenez",
                "Fredonia", sacosPredeterminados("Francisco Jimenez"));
        Caficultor caficultorPrueba2 = new Caficultor("8544689", "Yolanda Perez",
                "Armenia", sacosPredeterminados("Yolanda Perez"));
        Caficultor caficultorPrueba3 = new Caficultor("87456189", "Leopoldo Castro",
                "Manizales", sacosPredeterminados("Leopoldo Castro"));

        //TODO: Retornar la informacion acorde al nombre del caficultor enviado
        return Flux.merge(Mono.just(caficultorPrueba), Mono.just(caficultorPrueba2), Mono.just(caficultorPrueba3));
    }


    private ArrayList<Cafe> cafesPredeterminados(){
        Empaque empaquePrueba = new Empaque("bolsaAluminio", "Bolsa reciclable", 10f,
                3f, 300);
        Empaque empaquePrueba2 = new Empaque("frascoVidrio", "Frasco de vidrio", 50f,
                8f, 220);
        Cafe cafePrueba = new Cafe("CF-01", "Arabiga", 2200, "Andina",
                10f, 20f, empaquePrueba);
        Cafe cafePrueba2 = new Cafe("CF-02", "Castillo", 1400, "Andina",
                5f, 18.5f, empaquePrueba);
        Cafe cafePrueba3 = new Cafe("CF-03", "Robusta", 2300, "Andina",
                12f, 32.5f, empaquePrueba);
        Cafe cafePrueba4 = new Cafe("CF-04", "Borbon", 1850, "Andina",
                11f, 29.9f, empaquePrueba2);

        ArrayList cafes = new ArrayList();
        cafes.add(cafePrueba);
        cafes.add(cafePrueba2);
        cafes.add(cafePrueba3);
        cafes.add(cafePrueba4);

        return cafes;
    }

    private List<Saco> sacosPredeterminados(String nombreCaficultor){

        Saco sacoPrueba = new Saco(1,cafesPredeterminados().get(0),123.2,"material","01/02/2020");
        Saco sacoPrueba2 = new Saco(2,cafesPredeterminados().get(1),100.0,"material1","15/01/2022");
        Saco sacoPrueba3 = new Saco(3,cafesPredeterminados().get(2),50.4,"material2","22/08/2021");
        Saco sacoPrueba4 = new Saco(4,cafesPredeterminados().get(3),400.5,"material2","22/08/2021");

        HashMap<String,List<Saco>> sacosCaficultor = new HashMap<String,List<Saco>>();

        sacosCaficultor.put("Francisco Jimenez",new ArrayList<>());
        sacosCaficultor.get("Francisco Jimenez").add(sacoPrueba);

        sacosCaficultor.put("Yolanda Perez", new ArrayList<>());
        sacosCaficultor.get("Yolanda Perez").add(sacoPrueba2);

        sacosCaficultor.get("Francisco Jimenez").add(sacoPrueba3);

        sacosCaficultor.put("Leopoldo Castro", new ArrayList<>());
        sacosCaficultor.get("Leopoldo Castro").add(sacoPrueba4);

        return sacosCaficultor.get(nombreCaficultor);

    };
}
