package com.demo.spring_agenda.dto.request;

import com.demo.spring_agenda.model.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContatoRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    private LocalDate dataNascimento;

    @NotBlank(message = "Observações é obrigatório")
    private String observacoes;

    @NotNull(message = "ID do Endereço é obrigatório")
    private Long enderecoId;
}
