package com.demo.spring_agenda.controller;


import com.demo.spring_agenda.dto.request.EnderecoRequestDTO;
import com.demo.spring_agenda.dto.response.EnderecoResponseDTO;
import com.demo.spring_agenda.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;


    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> salvarEndereco(@RequestBody @Valid EnderecoRequestDTO dto){
        EnderecoResponseDTO response = enderecoService.cadastrarEndereco(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> buscarPorId(@PathVariable Long id){
        EnderecoResponseDTO response = enderecoService.buscarEnderecoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> buscarTodos(){
        return ResponseEntity.ok(enderecoService.buscarTodosEnderecos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> atualizar(@PathVariable Long id, @RequestBody EnderecoRequestDTO dto){
        EnderecoResponseDTO response = enderecoService.atualizarEndereco(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        enderecoService.deletarEnderecoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTodos(){
        enderecoService.deletarTodosEnderecos();
        return ResponseEntity.noContent().build();
    }
}
