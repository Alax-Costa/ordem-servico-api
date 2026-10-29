package com.alaxcosta.ordem_servico_api.controller;

import com.alaxcosta.ordem_servico_api.dto.TecnicoRequestDTO;
import com.alaxcosta.ordem_servico_api.model.Tecnico;
import com.alaxcosta.ordem_servico_api.service.TecnicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @PostMapping
    public ResponseEntity<Tecnico> cadastrar(@RequestBody @Valid TecnicoRequestDTO dto) {
        Tecnico novoTecnico = tecnicoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTecnico);
    }

    @GetMapping
    public ResponseEntity<List<Tecnico>> listarTodos() {
        List<Tecnico> tecnicos = tecnicoService.listarTodos();
        return ResponseEntity.ok(tecnicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> buscarPorId(@PathVariable Long id) {
        Tecnico tecnico = tecnicoService.buscarPorId(id);
        return ResponseEntity.ok(tecnico);
    }
}
