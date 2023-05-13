package com.maestro.todo.service;

import com.maestro.todo.dto.TarefaDTO;
import com.maestro.todo.model.Tarefa;

import java.util.List;

public interface TarefaService {
    Tarefa registarTarefa(TarefaDTO tarefaDTO);
    List<Tarefa> getTarefa();
    Tarefa findTarefaByNomeTarefa(String nomeTarefa);
    Tarefa updateTarefa();
    void deleteTarefa(long identificador);
    abstract String getEntityTopic();
}
