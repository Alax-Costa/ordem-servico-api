package com.alaxcosta.ordem_servico_api.repository;

import com.alaxcosta.ordem_servico_api.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TecnicoRepository extends JpaRepository<Tecnico,Long> {
}
