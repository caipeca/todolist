package com.maestro.todo.repository;

import com.maestro.todo.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Tarefa findByNomeTarefa(String nomeTarefa);
}
