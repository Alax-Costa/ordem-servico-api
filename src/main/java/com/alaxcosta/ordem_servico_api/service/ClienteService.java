package com.alaxcosta.ordem_servico_api.service;

import com.alaxcosta.ordem_servico_api.dto.ClienteRequestDTO;
import com.alaxcosta.ordem_servico_api.model.Cliente;
import com.alaxcosta.ordem_servico_api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import com.alaxcosta.ordem_servico_api.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvar(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setSenha(dto.senha()); // Em um projeto real, aqui aplicariamos criptografia (Spring Security)
        cliente.setDepartamento(dto.departamento());
        cliente.setTelefone(dto.telefone());

        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com o ID: " + id));
    }
}