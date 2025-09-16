package br.com.etechas.tarefas.dto;

import br.com.etechas.tarefas.enums.StatusEnum;

import java.time.LocalDate;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        LocalDate dataLimite,
        StatusEnum status,
        String responsavel
) {
    public LocalDate getDataLimite() {
        return null;
    }

    public String getTitulo() {
        return "";
    }

    public String getDescricao() {
        return "";
    }

    public String getResponsavel() {
        return "";
    }
}
