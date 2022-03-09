package com.reactivo.app.usecase;

import com.reactivo.app.data.CafeRepository;
import com.reactivo.app.modelos.Cafe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CafeUseCase {

    private CafeRepository repository;

    public Mono<Cafe> getCafeBySerialMono(String serial){
        return repository.findCafeBySerial(serial);
    }

    public Mono<String> getCostoCafeBySerialMono(String serial){
        Mono<Cafe> cafeMono = repository.findCafeBySerial(serial);
        return Mono.just(this.obtenerCadenaCostoTotalCafe(cafeMono));
    }

    public Flux<Cafe> getCafes(){
        return repository.findAll();
    }

    private String obtenerCadenaCostoTotalCafe(Mono<Cafe> cafeParam) {
        Cafe cafe = cafeParam.block();
        if(cafe == null){
            return "El cafe no existe";
        }
        if(cafe.getEmpaque() == null){
            return "El cafe no tiene empaque";
        }
        return "El costo total de este cafe es "
                + cafe.getCostoImportacion()
                + cafe.getPrecio()
                + cafe.getEmpaque().getCosto()
                + (cafe.getEmpaque().getPeso() * (cafe.getEmpaque().getCosto()/100));
    }
}
