package com.skillupai.service;

import com.skillupai.model.Matricula;
import com.skillupai.model.Trilha;
import com.skillupai.model.Usuario;
import com.skillupai.repository.MatriculaRepository;
import com.skillupai.repository.TrilhaRepository;
import com.skillupai.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TrilhaRepository trilhaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository,
                            UsuarioRepository usuarioRepository,
                            TrilhaRepository trilhaRepository) {
        this.matriculaRepository = matriculaRepository;
        this.usuarioRepository = usuarioRepository;
        this.trilhaRepository = trilhaRepository;
    }

    // 🔹 Listar todas as matrículas
    public List<Matricula> listarTodas() {
        return matriculaRepository.findAll();
    }

    // 🔹 Buscar matrícula por ID
    public Matricula buscarPorId(Long id) {
        return matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada com ID: " + id));
    }

    // 🔹 Criar matrícula
    public Matricula criar(Matricula matricula) {
        // Verifica se o usuário existe
        Usuario usuario = usuarioRepository.findById(matricula.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Verifica se a trilha existe
        Trilha trilha = trilhaRepository.findById(matricula.getTrilha().getId())
                .orElseThrow(() -> new RuntimeException("Trilha não encontrada"));

        matricula.setUsuario(usuario);
        matricula.setTrilha(trilha);

        return matriculaRepository.save(matricula);
    }

    // 🔹 Atualizar matrícula
    public Matricula atualizar(Long id, Matricula novaMatricula) {
        Matricula existente = buscarPorId(id);

        if (novaMatricula.getStatus() != null)
            existente.setStatus(novaMatricula.getStatus());

        if (novaMatricula.getUsuario() != null)
            existente.setUsuario(novaMatricula.getUsuario());

        if (novaMatricula.getTrilha() != null)
            existente.setTrilha(novaMatricula.getTrilha());

        return matriculaRepository.save(existente);
    }

    // 🔹 Deletar matrícula
    public void deletar(Long id) {
        Matricula matricula = buscarPorId(id);
        matriculaRepository.delete(matricula);
    }
}
