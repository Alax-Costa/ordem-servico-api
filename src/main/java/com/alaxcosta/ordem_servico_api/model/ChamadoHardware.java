package com.alaxcosta.ordem_servico_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_chamado_hardware")

public class ChamadoHardware extends Chamado {

    private String patrimonioEquipamento;
    private String tipoHardware;
}
