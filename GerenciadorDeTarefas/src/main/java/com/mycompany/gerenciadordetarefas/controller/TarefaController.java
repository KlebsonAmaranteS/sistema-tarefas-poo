package com.mycompany.gerenciadordetarefas.controller;


import com.mycompany.gerenciadordetarefas.model.Tarefa;
import com.mycompany.gerenciadordetarefas.model.TarefaService;

import java.util.List;

public class TarefaController {
    //    TarefaRepository tarefaRepository = new TarefaRepository();
//    TarefaService tarefaService = new TarefaService(tarefaRepository);
    private final TarefaRepository tarefaRepository;
    private final TarefaService tarefaService;

    public TarefaController(TarefaRepository tarefaRepository, TarefaService tarefaService) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaService = tarefaService;
    }

    public void removerTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);

        if (tarefas != null) {
            tarefaService.excluirTarefa(tarefas, titulo);
            tarefaRepository.salvarTarefas(tarefas);
        } else {
            throw new RuntimeException("Não foi possível carregar as tarefas.");
        }
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        tarefaService.cadastrarTarefa(tarefa);
    }

}