package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Tarefa> listarTarefas(){
        return repository.findAll();
    }
}
