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
@Table(name = "tb_tecnico")

public class Tecnico extends Usuario {
    private String especialidade;

    public Tecnico(long id, String nome, String senha, String email, String especialidade) {
        super(id, nome, senha, email);
        this.especialidade = especialidade;
    }
}
