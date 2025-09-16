package br.com.etechas.tarefas.controller;

import br.com.etechas.tarefas.dto.TarefaResponseDTO;
import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {
    @Autowired
    private TarefaService service;

    @GetMapping("/listarTarefas")
    public List<TarefaResponseDTO> listar() {

        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        if (service.excluirPorId(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/criarTarefas")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody TarefaResponseDTO dto) {
        //tem que retornar dto
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.criarTarefa(dto));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
