package aluno.ifpb.edu.br.gerenciadordetarefas.controller;


import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.TarefaService;

import java.util.List;
public class TarefaController {
    TarefaRepository tarefaRepository = new TarefaRepository();
    TarefaService tarefaService = new TarefaService(tarefaRepository);

    public void removerTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);

        if (tarefas != null) {
            TarefaService.excluirTarefa(tarefas, titulo);
            tarefaRepository.salvarTarefas(tarefas, usuario);
        } else {
            System.err.println("Não foi possível remover tarefa");
        }
    }

    public void cadastrarTarefa(Tarefa tarefa)  {
        tarefaService.cadastrarTarefa(tarefa);
    }

}