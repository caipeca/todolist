package com.maestro.todo.model;

import javax.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long identificador;
    private String nomeTarefa;
    private String estadoTarefa;

    public Tarefa(Long identificador, String nomeTarefa, String estadoTarefa) {
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

    public String getEstadoTarefa() {
        return estadoTarefa;
    }

    public void setEstadoTarefa(String estadoTarefa) {
        this.estadoTarefa = estadoTarefa;
    }
}
