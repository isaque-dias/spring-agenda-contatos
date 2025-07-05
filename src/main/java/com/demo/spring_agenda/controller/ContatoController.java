package com.demo.spring_agenda.controller;

import com.demo.spring_agenda.dto.request.ContatoRequestDTO;
import com.demo.spring_agenda.dto.response.ContatoResponseDTO;
import com.demo.spring_agenda.service.ContatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contatos")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;

    @PostMapping
    public ResponseEntity<ContatoResponseDTO> salvarContato(@RequestBody @Valid ContatoRequestDTO dto){
        ContatoResponseDTO response = contatoService.cadastrarContato(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> buscarPorId(@PathVariable Long id){
        ContatoResponseDTO response = contatoService.buscarContatoPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ContatoResponseDTO>> buscarTodos(){
        return ResponseEntity.ok(contatoService.buscarTodosContatos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> atualizar(@PathVariable Long id, @RequestBody ContatoRequestDTO dto){
        ContatoResponseDTO response = contatoService.atualizarContato(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        contatoService.deletarContatoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTodos(){
        contatoService.deletarTodosContatos();
        return ResponseEntity.noContent().build();
    }
}
