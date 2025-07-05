package com.demo.spring_agenda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "contato")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String email;

    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @OneToOne
    @JoinColumn(name = "endereco_id", unique = true, foreignKey = @ForeignKey(name = "fk_endereco"))
    private Endereco endereco;
}
