package com.spring.selmini.db.java.CRUD.domain;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "Tarefa")
@Entity(name = "tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String dataInicio;
    private String dataTermino;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "gestor_id")
    private Gestor gestor;

    public Tarefa(String titulo, String descricao, String dataInicion, String dataTermino, Gestor gestor, Colaborador colaborador) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicion;
        this.dataTermino = dataTermino;
        this.gestor = gestor;
        this.colaborador = colaborador;
        this.ativo = true;
    }

    public void removeTarefa() {
        this.ativo = false;
    }
}
