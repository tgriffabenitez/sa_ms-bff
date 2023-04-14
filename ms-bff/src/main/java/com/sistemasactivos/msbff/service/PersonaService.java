package com.sistemasactivos.msbff.service;

import com.sistemasactivos.msbff.model.Persona;
import com.sistemasactivos.msbff.utils.StatusCodeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PersonaService implements IPersonaService {

    @Autowired
    @Qualifier("webClientPersona")
    private WebClient webClient;

    public Flux<Persona> findAll() {
        return webClient.get()
                .uri("/personas")
                .retrieve()
                .bodyToFlux(Persona.class);
    }

    public Mono<Persona> findById(Long id) {
        return webClient.get()
                .uri("/persona/" + id)
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Persona.class));
    }

    public Mono<Persona> save(Persona persona) {
        return webClient.post()
                .uri("/personas")
                .bodyValue(persona)
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Persona.class));
    }

    public Mono<Void> delete(Long id) {
        return webClient.delete()
                .uri("/persona/" + id)
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Void.class));
    }

    public Mono<Persona> update(Long id, Persona persona) {
        return webClient.put()
                .uri("/persona/" + id)
                .bodyValue(persona)
                .exchangeToMono(clientResponse -> StatusCodeHandler.clientResponse(clientResponse, Persona.class));
    }
}
