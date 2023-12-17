package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.TarefaService;

import java.util.List;

public class TarefaController {
    private TarefaRepository tarefaRepository = new TarefaRepository();
    private TarefaService tarefaService = new TarefaService(tarefaRepository);

    public void removerTarefa(String usuario, String titulo) {
        try {
            List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);

            if (tarefas != null) {
                TarefaService.excluirTarefa(tarefas, titulo);
                tarefaRepository.salvarTarefas(tarefas, usuario);
            } else {
                throw new TarefaRemoverException("Não foi possível remover a tarefa.");
            }
        } catch (TarefaRemoverException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        try {
            tarefaService.cadastrarTarefa(tarefa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
