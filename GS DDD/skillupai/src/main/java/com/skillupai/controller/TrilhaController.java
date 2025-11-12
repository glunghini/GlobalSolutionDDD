package com.skillupai.controller;

import com.skillupai.model.Trilha;
import com.skillupai.service.TrilhaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhas")
public class TrilhaController {

    private final TrilhaService trilhaService;

    public TrilhaController(TrilhaService trilhaService) {
        this.trilhaService = trilhaService;
    }

    @GetMapping
    public List<Trilha> listarTodas() {
        return trilhaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trilha> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(trilhaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Trilha> criar(@RequestBody Trilha trilha) {
        return ResponseEntity.ok(trilhaService.criar(trilha));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trilha> atualizar(@PathVariable Long id, @RequestBody Trilha trilha) {
        return ResponseEntity.ok(trilhaService.atualizar(id, trilha));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        trilhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
