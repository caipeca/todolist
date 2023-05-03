package com.maestro.todo.model;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long identificador;
    private String nomeTarefa;
    private Enum estadoTarefa;

    public Tarefa(Long identificador, String nomeTarefa, Enum estadoTarefa) {
        this.identificador = identificador;
        this.nomeTarefa = nomeTarefa;
        this.estadoTarefa = estadoTarefa;
    }

    public Tarefa() {

    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public Enum getEstadoTarefa() {
        return estadoTarefa;
    }

    public void setEstadoTarefa(Enum estadoTarefa) {
        this.estadoTarefa = estadoTarefa;
    }
}
