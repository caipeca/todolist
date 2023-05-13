package com.maestro.todo.util.message;

import com.maestro.todo.model.Tarefa;

public class TarefaUpdateMessage {


    private final Tarefa adicionar;

    private final Tarefa atualizar;
    private final String removerTarefa;

    public TarefaUpdateMessage(Tarefa adicionar, Tarefa atualizar, String removerTarefa) {
        this.adicionar = adicionar;
        this.atualizar = atualizar;
        this.removerTarefa = removerTarefa;
    }

    public static TarefaUpdateMessage adicionar(final Tarefa tarefa){
        return new TarefaUpdateMessage(tarefa, null, null);
    }

    public static TarefaUpdateMessage atualizar(final Tarefa tarefa){
        return new TarefaUpdateMessage(null, tarefa,  null);
    }

    public static TarefaUpdateMessage eliminar(final String tarefa){
        return new TarefaUpdateMessage(null,null, tarefa);
    }

    public Tarefa getAdicionar() {
        return adicionar;
    }

    public Tarefa getAtualizar() {
        return atualizar;
    }

    public String getRemoverTarefa() {
        return removerTarefa;
    }
}
