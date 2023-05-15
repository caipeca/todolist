package com.maestro.todo.service.todo;

import com.maestro.todo.dto.TarefaDTO;
import com.maestro.todo.model.Tarefa;
import com.maestro.todo.repository.TarefaRepository;
import com.maestro.todo.service.TarefaService;
import com.maestro.todo.util.constant.EstadoConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private TarefaRepository repository;

    //private WebSocketService webSocketService;
    @Autowired
    public TarefaServiceImpl(TarefaRepository repository) {
        this.repository = repository;
        //this.webSocketService = webSocketService;
    }


    @Override
    public Tarefa registarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNomeTarefa(tarefaDTO.getNomeTarefa());
        tarefa.setEstadoTarefa(EstadoConstant.ESTADO_ABERTO);
        repository.save(tarefa);
        //notificarFrontend();
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
    public Tarefa updateTarefa(Tarefa tarefa) {

        Tarefa tarefaAtualizar = repository.findByIdentificador(tarefa.getIdentificador());

        tarefaAtualizar.setNomeTarefa(tarefa.getNomeTarefa());
        tarefaAtualizar.setEstadoTarefa(tarefa.getEstadoTarefa());
        repository.save(tarefaAtualizar);
        return tarefaAtualizar;
    }

    @Override
    public void deleteTarefa(long identificador) {
        repository.deleteById(identificador);
    }

    @Override
    public String getEntityTopic() {
        return "Tarefa";
    }

  /*
    private void notificarFrontend(){
        final String ENTITYTOPIC = getEntityTopic();
        if (ENTITYTOPIC == null) {
            LOGGER.error("Failed to get Entity topic");
            return;
        }
        webSocketService.sendMessage(ENTITYTOPIC);
    }
*/

}
