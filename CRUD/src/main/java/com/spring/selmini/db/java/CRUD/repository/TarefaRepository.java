package com.spring.selmini.db.java.CRUD.repository;

import com.spring.selmini.db.java.CRUD.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    Tarefa findByTitulo(String titulo);

    List<Tarefa> findByIdColaborador(Long id);
}
