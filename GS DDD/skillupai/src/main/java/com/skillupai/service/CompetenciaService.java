package com.skillupai.service;

import com.skillupai.exception.ResourceNotFoundException;
import com.skillupai.model.Competencia;
import com.skillupai.repository.CompetenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaService {

    private final CompetenciaRepository competenciaRepository;

    public CompetenciaService(CompetenciaRepository competenciaRepository) {
        this.competenciaRepository = competenciaRepository;
    }

    public List<Competencia> listarTodas() {
        return competenciaRepository.findAll();
    }

    public Competencia buscarPorId(Long id) {
        return competenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Competência não encontrada com ID: " + id));
    }

    public Competencia criar(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    public Competencia atualizar(Long id, Competencia competenciaAtualizada) {
        Competencia competencia = buscarPorId(id);
        competencia.setNome(competenciaAtualizada.getNome());
        competencia.setDescricao(competenciaAtualizada.getDescricao());
        competencia.setCategoria(competenciaAtualizada.getCategoria());
        return competenciaRepository.save(competencia);
    }

    public void deletar(Long id) {
        Competencia competencia = buscarPorId(id);
        competenciaRepository.delete(competencia);
    }
}
