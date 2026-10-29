package com.alaxcosta.ordem_servico_api.dto;

import com.alaxcosta.ordem_servico_api.model.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ChamadoHardwareRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotNull(message = "A prioridade é obrigatória")
        Prioridade prioridade,

        @NotNull(message = "O ID do cliente é obrigatório")
        Long clienteId,

        @NotBlank(message = "O patrimônio do equipamento é obrigatório")
        String patrimonioEquipamento,

        String tipoHardware
) {
}
