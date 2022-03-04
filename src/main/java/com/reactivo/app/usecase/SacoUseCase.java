package com.reactivo.app.usecase;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.modelos.Empaque;
import com.reactivo.app.modelos.Saco;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SacoUseCase {

    public Flux<Saco> getCafes(){
        Random rnd = new Random();
        List<Cafe> cafes = obtenerCafes();

        List<String> materiales = new ArrayList<>();
        materiales.add("Plastico");
        materiales.add("Carton");
        materiales.add("Papel");
        materiales.add("Tela");

        return Flux.fromStream(IntStream.range(1, 11).mapToObj(x -> new Saco(
                x,
                cafes.get(rnd.nextInt(4 - 1) + 1),
                rnd.nextFloat(),
                materiales.get(rnd.nextInt(4 - 1) + 1),
                "2022-03-02")));
    }

    private List<Cafe> obtenerCafes(){
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
}
