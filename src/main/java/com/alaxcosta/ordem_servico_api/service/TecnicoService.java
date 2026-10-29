package com.alaxcosta.ordem_servico_api.service;

import com.alaxcosta.ordem_servico_api.dto.TecnicoRequestDTO;
import com.alaxcosta.ordem_servico_api.model.Tecnico;
import com.alaxcosta.ordem_servico_api.repository.TecnicoRepository;
import org.springframework.stereotype.Service;
import com.alaxcosta.ordem_servico_api.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class TecnicoService {

    private final TecnicoRepository tecnicoRepository;

    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public Tecnico salvar(TecnicoRequestDTO dto) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome(dto.nome());
        tecnico.setEmail(dto.email());
        tecnico.setSenha(dto.senha());
        tecnico.setEspecialidade(dto.especialidade());

        return tecnicoRepository.save(tecnico);
    }

    public List<Tecnico> listarTodos() {
        return tecnicoRepository.findAll();
    }

    public Tecnico buscarPorId(Long id) {
        return tecnicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Técnico não encontrado com o ID: " + id));
    }
}