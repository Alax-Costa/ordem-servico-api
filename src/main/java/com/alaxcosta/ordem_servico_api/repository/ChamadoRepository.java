package com.alaxcosta.ordem_servico_api.repository;

import com.alaxcosta.ordem_servico_api.model.Chamado;
import com.alaxcosta.ordem_servico_api.model.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface ChamadoRepository extends JpaRepository<Chamado,Long> {

    List<Chamado> findByStatus(StatusChamado status);

    List<Chamado> findByClienteId(Long clienteId);

}
