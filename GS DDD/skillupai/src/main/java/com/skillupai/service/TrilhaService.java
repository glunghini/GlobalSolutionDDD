package com.skillupai.service;

import com.skillupai.exception.ResourceNotFoundException;
import com.skillupai.model.Competencia;
import com.skillupai.model.Trilha;
import com.skillupai.repository.CompetenciaRepository;
import com.skillupai.repository.TrilhaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TrilhaService {

    private final TrilhaRepository trilhaRepository;
    private final CompetenciaRepository competenciaRepository;

    public TrilhaService(TrilhaRepository trilhaRepository, CompetenciaRepository competenciaRepository) {
        this.trilhaRepository = trilhaRepository;
        this.competenciaRepository = competenciaRepository;
    }

    public List<Trilha> listarTodas() {
        return trilhaRepository.findAll();
    }

    public Trilha buscarPorId(Long id) {
        return trilhaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada com ID: " + id));
    }

    public Trilha criar(Trilha trilha) {
        validarCompetencias(trilha.getCompetencias());
        return trilhaRepository.save(trilha);
    }

    public Trilha atualizar(Long id, Trilha trilhaAtualizada) {
        Trilha trilha = buscarPorId(id);
        trilha.setNome(trilhaAtualizada.getNome());
        trilha.setDescricao(trilhaAtualizada.getDescricao());
        trilha.setFocoPrincipal(trilhaAtualizada.getFocoPrincipal());
        trilha.setNivel(trilhaAtualizada.getNivel());
        trilha.setCargaHoraria(trilhaAtualizada.getCargaHoraria());
        validarCompetencias(trilhaAtualizada.getCompetencias());
        trilha.setCompetencias(trilhaAtualizada.getCompetencias());
        return trilhaRepository.save(trilha);
    }

    public void deletar(Long id) {
        Trilha trilha = buscarPorId(id);
        trilhaRepository.delete(trilha);
    }

    private void validarCompetencias(Set<Competencia> competencias) {
        if (competencias != null) {
            for (Competencia comp : competencias) {
                if (comp.getId() != null && !competenciaRepository.existsById(comp.getId())) {
                    throw new ResourceNotFoundException("Competência com ID " + comp.getId() + " não encontrada.");
                }
            }
        }
    }
}
