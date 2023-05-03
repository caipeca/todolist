package com.maestro.todo.controller;

import com.maestro.todo.dto.TarefaDTO;
import com.maestro.todo.model.Tarefa;
import com.maestro.todo.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/"})
public class TarefaController {

    private TarefaService service;

    @Autowired
    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @PostMapping("/registar")
    public ResponseEntity<Tarefa> registar(@RequestBody TarefaDTO tarefaDTO){
        Tarefa tarefa = service.registarTarefa(tarefaDTO);
        return new ResponseEntity<>(tarefa, HttpStatus.OK);
    }

    //@PostMapping("")

    @GetMapping("/tarefa")
    public ResponseEntity<List<Tarefa>> getAllTarefa(){
        List<Tarefa> tarefa = service.getTarefa();
        return new ResponseEntity<>(tarefa, HttpStatus.OK);
    }
}
