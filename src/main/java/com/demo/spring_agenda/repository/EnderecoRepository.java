package com.demo.spring_agenda.repository;

import com.demo.spring_agenda.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
