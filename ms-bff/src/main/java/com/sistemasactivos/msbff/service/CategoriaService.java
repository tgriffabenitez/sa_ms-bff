package com.sistemasactivos.msbff.service;

import com.sistemasactivos.msbff.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    @Qualifier("webClientCategoria")
    private WebClient webClient;

    public Flux<Categoria> findAll() {
        return webClient.get()
                .uri("/categorias")
                .retrieve()
                .bodyToFlux(Categoria.class);
    }

    public Mono<Categoria> findById(Long id) {
        return webClient.get()
                .uri("/categoria/" + id)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Categoria.class);
    }

    public Mono<Categoria> save(Categoria categoria) {
        return webClient.post()
                .uri("/categorias")
                .body(Mono.just(categoria), Categoria.class)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Categoria.class);
    }

    public Mono<Void> delete(Long id) {
        return webClient.delete()
                .uri("/categoria/" + id)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Void.class);
    }

    public Mono<Categoria> update(Long id, Categoria categoria) {
        return webClient.put()
                .uri("/categoria/" + id)
                .body(Mono.just(categoria), Categoria.class)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Categoria.class);
    }
}
