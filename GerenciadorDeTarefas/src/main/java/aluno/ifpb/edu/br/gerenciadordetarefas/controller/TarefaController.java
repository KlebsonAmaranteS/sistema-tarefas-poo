package aluno.ifpb.edu.br.gerenciadordetarefas.controller;


import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.TarefaService;
import java.util.List;
public class TarefaController {
    TarefaRepository tarefaRepository = new TarefaRepository();

    public void removerTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);
        try{
            if (tarefas != null) {
                TarefaService.excluirTarefa(tarefas, titulo);
                tarefaRepository.salvarTarefas(tarefas, usuario);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}