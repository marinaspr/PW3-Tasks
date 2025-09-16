package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.TarefaResponseDTO;
import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.mapper.TarefaMapper;
import br.com.etechas.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.com.etechas.tarefas.dto.TarefaResponseDTO;


import java.time.LocalDate;
import java.util.List;
@Service
public class TarefaService {
    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public List<TarefaResponseDTO> findAll() {
        return tarefaMapper.toResponeDTO(repository.findAll());
    }

    public boolean excluirPorId(Long id) {
        var tarefa = repository.findById(id);
        if (tarefa.isEmpty()) {
            return false;
        }
        if (tarefa.get().isPending()) {
            repository.delete(tarefa.get());
            return true;
        }
        throw new RuntimeException("Tarefa em progresso ou concluída");
    }

    public Tarefa criarTarefa(TarefaResponseDTO dto) {
        LocalDate hoje = LocalDate.now();
        if (dto.getDataLimite().isBefore(hoje)) {
            throw new IllegalArgumentException("A data não pode ser anterior a atual");
        }
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setResponsavel(dto.getResponsavel());
        tarefa.setDataLimite(dto.getDataLimite());
        tarefa.setStatus("PENDING");

        return repository.save(tarefa);

//dto aqui
    }

}

