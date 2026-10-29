package com.alaxcosta.ordem_servico_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_cliente")

public class Cliente extends Usuario {
    private String departamento;
    private String telefone;

    public Cliente(long id, String nome, String senha, String email, String departamento, String telefone) {
        super(id, nome, senha, email);
        this.departamento = departamento;
    }
}
