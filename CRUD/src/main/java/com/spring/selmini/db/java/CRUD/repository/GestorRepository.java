package com.spring.selmini.db.java.CRUD.repository;

import com.spring.selmini.db.java.CRUD.domain.Gestor;
import com.spring.selmini.db.java.CRUD.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GestorRepository extends JpaRepository<Gestor, Long> {
    Optional<Gestor> findByEmail(String emailGestor);

    Optional<Gestor> findByNome(String nome);
}
