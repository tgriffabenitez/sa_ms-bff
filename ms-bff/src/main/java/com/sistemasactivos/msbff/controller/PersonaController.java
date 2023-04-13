package com.sistemasactivos.msbff.controller;

import com.sistemasactivos.msbff.model.Persona;
import com.sistemasactivos.msbff.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/personas")
    public Mono<Persona> save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/persona/{id}")
    public Mono<Persona> update(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.update(id, persona);
    }

    @DeleteMapping("/persona/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return personaService.delete(id);
    }


}
