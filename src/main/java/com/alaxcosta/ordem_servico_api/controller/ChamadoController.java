package com.alaxcosta.ordem_servico_api.controller;

import com.alaxcosta.ordem_servico_api.dto.ChamadoHardwareRequestDTO;
import com.alaxcosta.ordem_servico_api.dto.ChamadoResponseDTO;
import com.alaxcosta.ordem_servico_api.dto.ChamadoSoftwareRequestDTO;
import com.alaxcosta.ordem_servico_api.service.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {

    private final ChamadoService chamadoService;

    public ChamadoController(ChamadoService chamadoService) {
        this.chamadoService = chamadoService;
    }

    @PostMapping("/hardware")
    public ResponseEntity<ChamadoResponseDTO> criarHardware(@RequestBody @Valid ChamadoHardwareRequestDTO dto) {
        ChamadoResponseDTO novoChamado = chamadoService.criarChamadoHardware(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoChamado);
    }

    @PostMapping("/software")
    public ResponseEntity<ChamadoResponseDTO> criarSoftware(@RequestBody @Valid ChamadoSoftwareRequestDTO dto) {
        ChamadoResponseDTO novoChamado = chamadoService.criarChamadoSoftware(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoChamado);
    }

    @GetMapping
    public ResponseEntity<List<ChamadoResponseDTO>> listarTodos() {
        List<ChamadoResponseDTO> chamados = chamadoService.listarTodos();
        return ResponseEntity.ok(chamados);
    }
}
