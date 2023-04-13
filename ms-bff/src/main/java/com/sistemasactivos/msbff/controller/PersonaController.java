package com.sistemasactivos.msbff.controller;

import com.sistemasactivos.msbff.model.Persona;
import com.sistemasactivos.msbff.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public Flux<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/persona/{id}")
    public Mono<Persona> findById(@PathVariable Long id) {
        return personaService.findById(id);
    }

}
