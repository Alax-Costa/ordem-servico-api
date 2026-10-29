package com.alaxcosta.ordem_servico_api.service;

import com.alaxcosta.ordem_servico_api.dto.ChamadoHardwareRequestDTO;
import com.alaxcosta.ordem_servico_api.dto.ChamadoResponseDTO;
import com.alaxcosta.ordem_servico_api.dto.ChamadoSoftwareRequestDTO;
import com.alaxcosta.ordem_servico_api.exception.ResourceNotFoundException;
import com.alaxcosta.ordem_servico_api.model.*;
import com.alaxcosta.ordem_servico_api.repository.ChamadoRepository;
import com.alaxcosta.ordem_servico_api.repository.ClienteRepository;
import com.alaxcosta.ordem_servico_api.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;
    private final ClienteRepository clienteRepository;
    private final TecnicoRepository tecnicoRepository;

    public ChamadoService(ChamadoRepository chamadoRepository, ClienteRepository clienteRepository, TecnicoRepository tecnicoRepository) {
        this.chamadoRepository = chamadoRepository;
        this.clienteRepository = clienteRepository;
        this.tecnicoRepository = tecnicoRepository;
    }

    public ChamadoResponseDTO criarChamadoHardware(ChamadoHardwareRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + dto.clienteId()));

        ChamadoHardware chamado = new ChamadoHardware();
        chamado.setTitulo(dto.titulo());
        chamado.setDescricao(dto.descricao());
        chamado.setPrioridade(dto.prioridade());
        chamado.setStatus(StatusChamado.ABERTO);
        chamado.setDataAbertura(LocalDateTime.now());
        chamado.setCliente(cliente);
        chamado.setPatrimonioEquipamento(dto.patrimonioEquipamento());
        chamado.setTipoHardware(dto.tipoHardware());

        Chamado salvo = chamadoRepository.save(chamado);
        return converterParaDTO(salvo);
    }
    public ChamadoResponseDTO criarChamadoSoftware(ChamadoSoftwareRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com ID: " + dto.clienteId()));

        ChamadoSoftware chamado = new ChamadoSoftware();
        chamado.setTitulo(dto.titulo());
        chamado.setDescricao(dto.descricao());
        chamado.setPrioridade(dto.prioridade());
        chamado.setStatus(StatusChamado.ABERTO);
        chamado.setDataAbertura(LocalDateTime.now());
        chamado.setCliente(cliente);
        chamado.setNomeSistema(dto.nomeSistema());
        chamado.setVersaoSoftware(dto.versaoSoftware());

        Chamado salvo = chamadoRepository.save(chamado);
        return converterParaDTO(salvo);
    }
    public List<ChamadoResponseDTO> listarTodos() {
        return chamadoRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private ChamadoResponseDTO converterParaDTO(Chamado chamado) {
        String nomeTecnico = (chamado.getTecnico() != null) ? chamado.getTecnico().getNome() : "Não atribuído";

        return new ChamadoResponseDTO(
                chamado.getId(),
                chamado.getTitulo(),
                chamado.getDescricao(),
                chamado.getStatus(),
                chamado.getPrioridade(),
                chamado.getDataAbertura(),
                chamado.getDataFechamento(),
                chamado.getCliente().getNome(),
                nomeTecnico
        );
    }
}
