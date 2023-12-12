package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.TarefaService;

import java.util.List;

public class TarefaController {
    private final TarefaRepository tarefaRepository;
    private final TarefaService tarefaService;

    public TarefaController() {
        this.tarefaRepository = new TarefaRepository();
        this.tarefaService = new TarefaService(tarefaRepository);
    }

    public void removerTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);

        if (tarefas != null) {
            TarefaService.excluirTarefa(tarefas, titulo);
            tarefaRepository.salvarTarefas(tarefas);
        } else {
            throw new RuntimeException("Não foi possível carregar tarefas para o usuário: " + usuario);
        }
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        tarefaService.cadastrarTarefa(tarefa);
    }
}
