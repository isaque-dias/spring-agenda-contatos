package com.demo.spring_agenda.service;

import com.demo.spring_agenda.dto.request.ContatoRequestDTO;
import com.demo.spring_agenda.dto.response.ContatoResponseDTO;
import com.demo.spring_agenda.exception.ResourceNotFoundException;
import com.demo.spring_agenda.model.Contato;
import com.demo.spring_agenda.model.Endereco;
import com.demo.spring_agenda.repository.ContatoRepository;
import com.demo.spring_agenda.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;


    public ContatoResponseDTO cadastrarContato(ContatoRequestDTO dto){
        Contato contato = toEntity(dto);
        Contato contatoSalvo = contatoRepository.save(contato);
        return toResponse(contatoSalvo);
    }


    public ContatoResponseDTO buscarContatoPorId(Long id){
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado com o ID: " + id));

        return toResponse(contato);
    }


    public List<ContatoResponseDTO> buscarTodosContatos(){
        List<Contato> contatos = contatoRepository.findAll();

        return contatos.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ContatoResponseDTO atualizarContato(Long id, ContatoRequestDTO dto){
        Contato contato = contatoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("Contato não encontrado com o ID: " + id)));

        contato.setNome(dto.getNome());
        contato.setEmail(dto.getEmail());
        contato.setTelefone(dto.getTelefone());
        contato.setDataNascimento(dto.getDataNascimento());
        contato.setObservacoes(dto.getObservacoes());

        Endereco endereco = enderecoRepository.findById(dto.getEnderecoId())
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o ID: " + dto.getEnderecoId()));

        contato.setEndereco(endereco);

        Contato contatoAtualizado = contatoRepository.save(contato);

        return toResponse(contatoAtualizado);
    }


    public void deletarContatoPorId(Long id){
        if(!contatoRepository.existsById(id)){
            throw new ResourceNotFoundException("Contato não encontrado com o ID: " + id);
        }

        contatoRepository.deleteById(id);
    }


    public void deletarTodosContatos(){
        contatoRepository.deleteAll();
    }


    private Contato toEntity(ContatoRequestDTO dto){
        // Buscar o Endereco correspondente ao enderecoId
        Endereco endereco = enderecoRepository.findById(dto.getEnderecoId())
                .orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com o ID: " + dto.getEnderecoId()));
        return Contato.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .telefone(dto.getTelefone())
                .dataNascimento(dto.getDataNascimento())
                .observacoes(dto.getObservacoes())
                .endereco(endereco)
                .build();
    }

    private ContatoResponseDTO toResponse(Contato contato){
        return ContatoResponseDTO.builder()
                .id(contato.getId())
                .nome(contato.getNome())
                .email(contato.getEmail())
                .telefone(contato.getTelefone())
                .dataNascimento(contato.getDataNascimento())
                .obervacoes(contato.getObservacoes())
                .enderecoId(contato.getEndereco())
                .build();
    }
}
