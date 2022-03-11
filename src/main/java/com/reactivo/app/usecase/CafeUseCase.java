package com.reactivo.app.usecase;

import com.reactivo.app.modelos.Cafe;
import com.reactivo.app.modelos.Empaque;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
public class CafeUseCase {

    public String obtenerCostoTotalCafeCadena(Cafe cafe){
        return "El costo total de este cafe es "
                + cafe.getCostoImportacion()
                + cafe.getPrecio()
                + cafe.getEmpaque().getCosto()
                + (cafe.getEmpaque().getPeso() * (cafe.getEmpaque().getCosto()/100));
    }

    public Cafe obtenerCafeId (String id){
        //TODO: Se removeran una vez se tenga la conexion a la base de datos
        final String idCafePrueba = "CF-01";
        final String idCafePrueba2 = "CF-02";
        Empaque empaquePrueba = new Empaque("bolsaAluminio", "Bolsa reciclable", 10f,
                3f, 300);
        Cafe cafePrueba = new Cafe(idCafePrueba, "Arabiga", 2200, "Andina",
                10f, 20f, empaquePrueba);
        Cafe cafePrueba2 = new Cafe(idCafePrueba2, "Castillo", 1400, "Andina",
                5f, 18.5f, empaquePrueba);
        if(idCafePrueba.equalsIgnoreCase(id)){
            return cafePrueba;
        }
        if(idCafePrueba2.equalsIgnoreCase(id)){
            return cafePrueba2;
        }
        return new Cafe();
    }

    public Flux<Cafe> obtenerCafes(){
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
        Mono<Cafe> cafe1 = Mono.just(cafePrueba);
        Mono<Cafe> cafe2 = Mono.just(cafePrueba2);
        Mono<Cafe> cafe3 = Mono.just(cafePrueba3);
        Mono<Cafe> cafe4 = Mono.just(cafePrueba4);
        return Flux.merge(cafe1, cafe2, cafe3, cafe4);
    }

    public Mono<String> obtenerCostoCafeById(String id){
        final String idCafePrueba = "CF-01";
        final String idCafePrueba2 = "CF-02";
        Empaque empaquePrueba = new Empaque("bolsaAluminio", "Bolsa reciclable", 10f,
                3f, 300);
        Cafe cafePrueba = new Cafe(idCafePrueba, "Arabiga", 2200, "Andina",
                10f, 20f, empaquePrueba);
        Cafe cafePrueba2 = new Cafe(idCafePrueba2, "Castillo", 1400, "Andina",
                5f, 18.5f, empaquePrueba);
        if(idCafePrueba.equalsIgnoreCase(id)){
            return Mono.just(obtenerCostoTotalCafeCadena(cafePrueba));
        }
        if(idCafePrueba2.equalsIgnoreCase(id)){
            return Mono.just(obtenerCostoTotalCafeCadena(cafePrueba2));
        }
        return Mono.just("No existe el cafe con el serial solicitado");
    }


}
