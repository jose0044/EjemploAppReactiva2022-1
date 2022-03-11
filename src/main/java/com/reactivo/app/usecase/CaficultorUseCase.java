package com.reactivo.app.usecase;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.modelos.Caficultor;
import com.reactivo.app.modelos.Empaque;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class CaficultorUseCase {

    public Mono<Caficultor> obtenerCaficultorById(String id){
        Caficultor caficultorPrueba = new Caficultor("32456129", "Francisco Jimenez",
                "Fredonia", cafesPredeterminados());

        return Mono.just(caficultorPrueba);
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

    public Flux<Caficultor> obtenerCaficultores(){
        Caficultor caficultorPrueba = new Caficultor("32456129", "Francisco Jimenez",
                "Fredonia", cafesPredeterminados());
        Caficultor caficultorPrueba2 = new Caficultor("8544689", "Yolanda Perez",
                "Armenia", cafesPredeterminados());
        Caficultor caficultorPrueba3 = new Caficultor("87456189", "Leopoldo Castro",
                "Manizales", cafesPredeterminados());

        return Flux.merge(Mono.just(caficultorPrueba), Mono.just(caficultorPrueba2), Mono.just(caficultorPrueba3));
    }
}
