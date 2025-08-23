package com.spring.selmini.db.java.CRUD.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "COLABORADOR")
@Entity(name = "colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "gestor_id")
    private Gestor gestor;

    @OneToMany(mappedBy = "colaborador")
    private List<Tarefa> tarefas;


    public Colaborador(String nome, String email, Gestor gestor) {
        this.nome = nome;
        this.email = email;
        this.gestor = gestor;
        this.ativo = true;
    }

    public void removeGestor() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
