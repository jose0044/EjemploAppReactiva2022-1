package com.reactivo.app.data;

import com.reactivo.app.modelos.Cafe;
import reactor.core.publisher.Mono;

//TODO: Agregar conexiones con Base de Datos
public interface CafeRepository {
    Mono<Cafe> findCafeById(String id);
}
