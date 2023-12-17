package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.TarefaService;
import java.util.List;

public class TarefaController {
<<<<<<< HEAD
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
=======
    TarefaRepository tarefaRepository = new TarefaRepository();

    public void removerTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);
        try{
            if (tarefas != null) {
                TarefaService.excluirTarefa(tarefas, titulo);
                tarefaRepository.salvarTarefas(tarefas, usuario);
            }
        }catch (Exception e) {
>>>>>>> 3a908b151b33b218a4344de0913dc3e3dc718cf2
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
    public void cadastrarTarefa(Tarefa tarefa) {
        try {
            tarefaService.cadastrarTarefa(tarefa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======
}
>>>>>>> 3a908b151b33b218a4344de0913dc3e3dc718cf2
