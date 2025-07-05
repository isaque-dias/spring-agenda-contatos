package com.demo.spring_agenda.service;


import com.demo.spring_agenda.dto.request.EnderecoRequestDTO;
import com.demo.spring_agenda.dto.response.EnderecoResponseDTO;
import com.demo.spring_agenda.exception.ResourceNotFoundException;
import com.demo.spring_agenda.model.Endereco;
import com.demo.spring_agenda.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;


    public EnderecoResponseDTO cadastrarEndereco(EnderecoRequestDTO dto){
        Endereco endereco = toEntity(dto);
        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        return toResponse(enderecoSalvo);
    }

    public EnderecoResponseDTO buscarEnderecoPorId(Long id){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o ID: " + id));

        return toResponse(endereco);
    }

    public List<EnderecoResponseDTO> buscarTodosEnderecos(){
        List<Endereco> enderecos = enderecoRepository.findAll();

        return enderecos.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public EnderecoResponseDTO atualizarEndereco(Long id, EnderecoRequestDTO dto){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o ID: " + id));

        endereco.setRua(dto.getRua());
        endereco.setNumero(dto.getNumero());
        endereco.setBairro(dto.getBairro());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setCep(dto.getCep());
        endereco.setPais(dto.getPais());

        Endereco enderecoAtualizado = enderecoRepository.save(endereco);

        return toResponse(enderecoAtualizado);
    }

    public void deletarEnderecoPorId(Long id){
        if(!enderecoRepository.existsById(id)){
            throw new ResourceNotFoundException("Endereço não encontrado com o ID: " + id);
        }

        enderecoRepository.deleteById(id);
    }

    public void deletarTodosEnderecos(){
        enderecoRepository.deleteAll();
    }


    private Endereco toEntity(EnderecoRequestDTO dto){
        return Endereco.builder()
                .rua(dto.getRua())
                .numero(dto.getNumero())
                .bairro(dto.getBairro())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .cep(dto.getCep())
                .pais(dto.getPais())
                .build();
    }

    private EnderecoResponseDTO toResponse(Endereco endereco){
        return EnderecoResponseDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .numero(endereco.getNumero())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .pais(endereco.getPais())
                .build();
    }
}
