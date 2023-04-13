package com.sistemasactivos.msbff.service;

import com.sistemasactivos.msbff.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaService {
    Flux<Persona> findAll();
    Mono<Persona> findById(Long id);
    Mono<Persona> save(Persona persona);
    Mono<Void> delete(Long id);
    Mono<Persona> update(Long id, Persona persona);
}
