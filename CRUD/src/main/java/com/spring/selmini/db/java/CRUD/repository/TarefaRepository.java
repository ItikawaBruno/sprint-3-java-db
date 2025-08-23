package com.spring.selmini.db.java.CRUD.repository;

import com.spring.selmini.db.java.CRUD.domain.Colaborador;
import com.spring.selmini.db.java.CRUD.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    Tarefa findByTitulo(String titulo);

    List<Tarefa> findByColaborador(Optional<Colaborador> colaborador);
}
