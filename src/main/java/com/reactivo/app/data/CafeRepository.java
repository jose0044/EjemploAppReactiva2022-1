package com.reactivo.app.data;

import com.reactivo.app.modelos.Cafe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CafeRepository extends ReactiveMongoRepository<Cafe, String> {
    Mono<Cafe> findCafeBySerial(String id);
    Flux<Cafe> findAll();
}
