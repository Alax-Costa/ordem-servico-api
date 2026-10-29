package com.alaxcosta.ordem_servico_api.dto;

import com.alaxcosta.ordem_servico_api.model.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChamadoSoftwareRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "A prioridade é obrigatória")
        Prioridade prioridade,

        @NotNull(message = "O ID do cliente é obrigatório")
        Long clienteId,

        @NotBlank(message = "O nome do sistema é obrigatório")
        String nomeSistema,

        String versaoSoftware
) {
}
