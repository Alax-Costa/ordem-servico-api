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
@Table(name = "tb_chamado_software")

public class ChamadoSoftware extends Chamado {

    private String nomeSistema;
    private String versaoSoftware;
}
