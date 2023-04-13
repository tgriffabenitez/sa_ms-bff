package com.sistemasactivos.msbff.service;

import com.sistemasactivos.msbff.model.Categoria;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICategoriaService {
    Flux<Categoria> findAll();
    Mono<Categoria> findById(Long id);
    Mono<Categoria> save(Categoria categoria);
    Mono<Void> delete(Long id);
    Mono<Categoria> update(Long id, Categoria categoria);
}
