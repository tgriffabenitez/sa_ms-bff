package com.sistemasactivos.msbff.controller;

import com.sistemasactivos.msbff.model.Categoria;
import com.sistemasactivos.msbff.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public Flux<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/categoria/{id}")
    public Mono<Categoria> findById(@PathVariable Long id) {
        return categoriaService.findById(id);
    }

    @PostMapping("/categorias")
    public Mono<Categoria> save(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/categoria/{id}")
    public Mono<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.update(id, categoria);
    }

    @DeleteMapping("/categoria/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return categoriaService.delete(id);
    }


}
