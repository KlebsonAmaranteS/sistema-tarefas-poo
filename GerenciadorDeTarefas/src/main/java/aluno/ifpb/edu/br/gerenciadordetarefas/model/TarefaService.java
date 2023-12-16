package aluno.ifpb.edu.br.gerenciadordetarefas.model;

import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaRepository;

import java.util.List;
import java.util.Optional;

public class TarefaService {
    private final TarefaRepository tarefaPersistence;

    public TarefaService(TarefaRepository tarefaPersistence) {
        this.tarefaPersistence = tarefaPersistence;
    }

    public List<Tarefa> carregarTarefas(String usuario) {
        List<Tarefa> todasAsTarefas = TarefaRepository.carregarTarefas(usuario);

        return todasAsTarefas.stream()
                .filter(tarefa -> tarefa.getUsuario().equals(usuario))
                .toList();
    }



    public void cadastrarTarefa(Tarefa tarefaEditada) {
        List<Tarefa> todasAsTarefas = carregarTarefas(tarefaEditada.getUsuario());

        try{
            if (todasAsTarefas != null) {
                Optional<Tarefa> tarefaOriginal = todasAsTarefas.stream()
                        .filter(t -> t.getTitulo().equals(tarefaEditada.getTitulo()))
                        .findFirst();

                tarefaOriginal.ifPresent(original -> {
                    original.setDescricao(tarefaEditada.getDescricao());
                    original.setDataConclusao(tarefaEditada.getDataConclusao());
                    original.setConcluida(tarefaEditada.isConcluida());
                    original.setImportancia(tarefaEditada.getImportancia());
                });

                tarefaPersistence.salvarTarefas(todasAsTarefas, tarefaEditada.getUsuario());
        }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void excluirTarefa(List<Tarefa> tarefas, String titulo) {
        tarefas.removeIf(tarefa -> tarefa.getTitulo().equals(titulo));
    }
    
}