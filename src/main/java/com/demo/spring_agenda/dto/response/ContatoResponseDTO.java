package com.demo.spring_agenda.dto.response;

import com.demo.spring_agenda.model.Endereco;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContatoResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private String obervacoes;
    private Endereco enderecoId;
}
