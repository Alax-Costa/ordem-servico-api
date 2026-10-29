package com.alaxcosta.ordem_servico_api.dto;

import com.alaxcosta.ordem_servico_api.model.Prioridade;
import com.alaxcosta.ordem_servico_api.model.StatusChamado;

import java.time.LocalDateTime;

public record ChamadoResponseDTO(
        Long id,
        String titulo,
        String descricao,
        StatusChamado status,
        Prioridade prioridade,
        LocalDateTime dataAbertura,
        LocalDateTime dataFechamento,
        String nomeCliente,
        String nomeTecnico
) {
}
