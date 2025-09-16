package br.com.etechas.tarefas.schedule;

import br.com.etechas.tarefas.enums.StatusEnum;
import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
public class ScheduledTask {

    @Autowired
    private TarefaRepository taskRepository;

    private static final String[] TASK_TITLES = {
            "Revisar código",
            "Atualizar documentação",
            "Fazer backup do sistema",
            "Verificar logs de erro",
            "Executar testes automatizados",
            "Monitorar performance",
            "Limpar cache",
            "Verificar segurança",
            "Avaliar TCC da Marion",
            "comer morango do amor",
            "pintar bobbie goods",
            "comer sorvete de pistache",
            "acompanhar os storys da floflo e da virginia",
            ""
    };

    private static final String[] TASK_DESCRIPTIONS = {
            "Revisar o código desenvolvido na última semana",
            "Atualizar a documentação do projeto",
            "Realizar backup automático do sistema",
            "Verificar e analisar logs de erro",
            "Executar bateria de testes automatizados",
            "Monitorar performance e uso de recursos",
            "Limpar cache para otimizar performance",
            "Verificar questões de segurança",
            "Avaliar TCC da Marion de 2025",
            "comer morango do amor uma vez por dia",
            "pintar bobbie goods enquanto come morango do amor",
            "comer sorvete de pistache enquanto ve os storys",
            "acompanhar os storys da floflo e da virginia",
            "Aumentar o salários dos pedreiros"
    };

    private static final String[] RESPONSIBLES = {
            "Sistema Automático",
            "Administrador",
            "Desenvolvedor",
            "Analista de Qualidade",
            "DevOps"
    };

    @Scheduled(fixedRate = 6000)
    public void createAutomaticTask() {
        Random random = new Random();

        Tarefa tarefa = new Tarefa();

        // Seleciona aleatoriamente um título e descrição
        int index = random.nextInt(TASK_TITLES.length);
        tarefa.setTitulo(TASK_TITLES[index]);
        tarefa.setDescricao(TASK_DESCRIPTIONS[index]);


        // Define data de vencimento para a partir de hoje
        tarefa.setDataLimite(LocalDate.now().plusDays(1)
                .plusDays(random.nextInt(10)));

        // Define status como PENDING
        tarefa.setStatus(String.valueOf(StatusEnum.values()[random.nextInt(3)]));

        // Define um responsável aleatório
        tarefa.setResponsavel(RESPONSIBLES[random.nextInt(RESPONSIBLES.length)]);

        // Salva a tarefa no banco
        taskRepository.save(tarefa);

        System.out.println("Tarefa automática criada: " + tarefa.getTitulo() +
                " - Responsável: " + tarefa.getResponsavel() +
                " - Data: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
} 