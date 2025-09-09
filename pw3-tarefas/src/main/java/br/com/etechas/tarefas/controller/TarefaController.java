package br.com.etechas.tarefas.controller;

import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.repository.TaskRepository;
import br.com.etechas.tarefas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/tarefas")
public class TaskController {
    @Autowired
    private TaskService service;


    @GetMapping ("/listarTarefas")
    public List<Tarefa> listar(){
        return service.listarTarefas();
    }
}
