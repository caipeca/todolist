package com.maestro.todo.controller;

import com.maestro.todo.dto.TarefaDTO;
import com.maestro.todo.model.Tarefa;
import com.maestro.todo.service.TarefaService;
import com.maestro.todo.util.message.TarefaUpdateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/"})
@CrossOrigin("http://localhost:4200/")
public class TarefaController {

    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private TarefaService service;
    private final SimpMessagingTemplate MESSAGINGTEMPLATE;

    @Autowired
    public TarefaController(TarefaService service, SimpMessagingTemplate messagingtemplate) {
        this.service = service;
        MESSAGINGTEMPLATE = messagingtemplate;
    }

    @PostMapping("/registar")
    public ResponseEntity<Tarefa> registar(@RequestBody TarefaDTO tarefaDTO){

        Tarefa tarefa = service.registarTarefa(tarefaDTO);
        this.enviar(tarefaDTO.getIdentificador() == null ? TarefaUpdateMessage.adicionar(tarefa):TarefaUpdateMessage.atualizar(tarefa));
        return new ResponseEntity<>(tarefa, HttpStatus.OK);
    }

    //@PostMapping("")

    @GetMapping("/tarefa")
    public ResponseEntity<List<Tarefa>> getAllTarefa(){
        List<Tarefa> tarefa = service.getTarefa();
        return new ResponseEntity<>(tarefa, HttpStatus.OK);
    }

    private void enviar(TarefaUpdateMessage message){
        this.MESSAGINGTEMPLATE.convertAndSend("/tarefa/tarefas",message);
    }
}
