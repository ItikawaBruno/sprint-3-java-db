package com.spring.selmini.db.java.CRUD.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "GESTOR")
@Entity(name = "gestor")
public class Gestor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private boolean ativo;

    @OneToMany(mappedBy = "gestor")
    private List<Tarefa> tarefas;

    public Gestor(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.ativo = true;
    }

    public void removeGestor() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Gestor{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
