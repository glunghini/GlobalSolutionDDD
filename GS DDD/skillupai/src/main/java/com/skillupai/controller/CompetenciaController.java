package com.skillupai.controller;

import com.skillupai.model.Competencia;
import com.skillupai.service.CompetenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/competencias")
public class CompetenciaController {

    private final CompetenciaService service;

    public CompetenciaController(CompetenciaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Competencia> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competencia> buscar(@PathVariable Long id) {
        Competencia competencia = service.buscarPorId(id);
        return ResponseEntity.ok(competencia);
    }

    @PostMapping
    public ResponseEntity<Competencia> criar(@Valid @RequestBody Competencia competencia) {
        Competencia criada = service.criar(competencia);
        return ResponseEntity.created(URI.create("/competencias/" + criada.getId())).body(criada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competencia> atualizar(@PathVariable Long id, @Valid @RequestBody Competencia competencia) {
        Competencia atualizada = service.atualizar(id, competencia);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
