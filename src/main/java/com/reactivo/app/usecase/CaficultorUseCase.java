package com.reactivo.app.usecase;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.modelos.Caficultor;
import com.reactivo.app.modelos.Empaque;
import com.reactivo.app.modelos.Saco;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CaficultorUseCase {

    public Mono<Caficultor> getCaficultorById(String id){

        ArrayList<Cafe> cafes = cafesPredeterminados();
        Map<Integer, Saco> sacos = this.sacosAsociados(cafes);

        Caficultor caficultorPrueba = new Caficultor("32456129", "Francisco Jimenez",
                "Fredonia", cafes, sacos);

        return Mono.just(caficultorPrueba);
    }

    public Flux<Caficultor> getCaficultores(){
        ArrayList<Cafe> cafes = cafesPredeterminados();
        Map<Integer, Saco> sacos = this.sacosAsociados(cafes);

        Caficultor caficultorPrueba = new Caficultor("32456129", "Francisco Jimenez",
                "Fredonia", cafes, sacos);
        Caficultor caficultorPrueba2 = new Caficultor("8544689", "Yolanda Perez",
                "Armenia", cafes, sacos);
        Caficultor caficultorPrueba3 = new Caficultor("87456189", "Leopoldo Castro",
                "Manizales", cafes, sacos);

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

        ArrayList<Cafe> cafes = new ArrayList<>();
        cafes.add(cafePrueba);
        cafes.add(cafePrueba2);
        cafes.add(cafePrueba3);
        cafes.add(cafePrueba4);

        return cafes;
    }

    private Map<Integer, Saco> sacosAsociados(List<Cafe> cafes) {
        Map<Integer, Saco> sacos = new HashMap<>();
        List<String> materiales = new ArrayList<>();
        materiales.add("Plastico");
        materiales.add("Carton");
        materiales.add("Papel");
        materiales.add("Tela");

        Random rnd = new Random();

        for (int i = 0; i < 15; i++) {
            sacos.put(i,
                    new Saco(
                            i,
                            cafes.get(rnd.nextInt(4 - 1) + 1),
                            rnd.nextFloat(),
                            materiales.get(rnd.nextInt(4 - 1) + 1),
                            "2022-03-02")
            );
        }

        return sacos;
    }
}
