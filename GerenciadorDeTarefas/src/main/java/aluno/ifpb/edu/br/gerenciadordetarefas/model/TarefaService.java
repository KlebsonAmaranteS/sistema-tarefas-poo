package aluno.ifpb.edu.br.gerenciadordetarefas.model;

import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TarefaService {
    private final TarefaRepository tarefaPersistence;

    public TarefaService(TarefaRepository tarefaPersistence) {
        this.tarefaPersistence = tarefaPersistence;
    }

    public List<Tarefa> carregarTarefas(String usuario) {
        List<Tarefa> todasAsTarefas = TarefaRepository.carregarTarefas(usuario);

        return todasAsTarefas.stream()
                .filter(tarefa -> tarefa.getUsuario().equals(usuario))
                .collect(Collectors.toList());
    }



    public void cadastrarTarefa(Tarefa tarefaEditada) {
        List<Tarefa> todasAsTarefas = carregarTarefas(tarefaEditada.getUsuario());

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
        } else {
            System.err.println("Não foi possível carregar as tarefas");
        }
    }

    public static void excluirTarefa(List<Tarefa> tarefas, String titulo) {
        tarefas.removeIf(tarefa -> tarefa.getTitulo().equals(titulo));
    }

    private static void handleException(Exception e, String message) {
        e.printStackTrace();
        System.err.println(message);
    }
}