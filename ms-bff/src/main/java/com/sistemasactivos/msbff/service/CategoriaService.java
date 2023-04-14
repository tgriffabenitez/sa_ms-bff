package com.sistemasactivos.msbff.service;

import com.sistemasactivos.msbff.model.Categoria;
import com.sistemasactivos.msbff.utils.StatusCodeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Categoria.class));
    }

    public Mono<Categoria> save(Categoria categoria) {
        return webClient.post()
                .uri("/categorias")
                .bodyValue(categoria)
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Categoria.class));
    }

    public Mono<Void> delete(Long id) {
        return webClient.delete()
                .uri("/categoria/" + id)
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Void.class));
    }

    public Mono<Categoria> update(Long id, Categoria categoria) {
        return webClient.put()
                .uri("/categoria/" + id)
                .bodyValue(categoria)
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Categoria.class));
    }
}
