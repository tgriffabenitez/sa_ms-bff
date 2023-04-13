package com.sistemasactivos.msbff.service;

import com.sistemasactivos.msbff.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PersonaService implements IPersonaService {
    @Autowired
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
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Persona.class);
    }

    public Mono<Persona> save(Persona persona) {
        System.out.println("Persona: " + persona.getApellido());
        return webClient.post()
                .uri("/personas")
                .body(Mono.just(persona), Persona.class)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Persona.class);
    }

    public Mono<Void> delete(Long id) {
        return webClient.delete()
                .uri("/persona/" + id)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Void.class);
    }

    public Mono<Persona> update(Long id, Persona persona) {
        return webClient.put()
                .uri("/persona/" + id)
                .body(Mono.just(persona), Persona.class)
                .retrieve()
                .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())
                .bodyToMono(Persona.class);
    }
}
