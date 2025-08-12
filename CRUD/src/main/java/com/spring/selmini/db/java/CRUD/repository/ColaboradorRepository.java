package com.spring.selmini.db.java.CRUD.repository;

import com.spring.selmini.db.java.CRUD.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColaboradorRepository extends JpaRepository<Colaborador,Long> {
    Optional<Colaborador> findByNome(String nome);

    Optional<Colaborador> findByEmail(String email);
}
