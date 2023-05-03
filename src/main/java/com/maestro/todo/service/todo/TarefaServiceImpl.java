package com.maestro.todo.service.todo;

import com.maestro.todo.dto.TarefaDTO;
import com.maestro.todo.model.Tarefa;
import com.maestro.todo.repository.TarefaRepository;
import com.maestro.todo.service.TarefaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.maestro.todo.enumeration.Estado.*;

@Service
public class TarefaServiceImpl implements TarefaService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private TarefaRepository repository;

    @Autowired
    public TarefaServiceImpl(TarefaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tarefa registarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNomeTarefa(tarefa.getNomeTarefa());
        tarefa.setEstadoTarefa(ABERTO);
        repository.save(tarefa);
        return tarefa;
    }

    @Override
    public List<Tarefa> getTarefa() {
        return repository.findAll();
    }

    @Override
    public Tarefa findTarefaByNomeTarefa(String nomeTarefa) {
        return repository.findByNomeTarefa(nomeTarefa);
    }

    @Override
    public Tarefa updateTarefa() {
        return null;
    }

    @Override
    public void deleteTarefa(long identificador) {
        repository.deleteById(identificador);
    }
}
