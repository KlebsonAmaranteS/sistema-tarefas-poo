package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

import static aluno.ifpb.edu.br.gerenciadordetarefas.view.TelaLoginView.usuarioLogado;

public class TarefaController {
    private TarefaRepository tarefaRepository;

    public TarefaController(){
        this.tarefaRepository = new TarefaRepository();
    }

    public void removerTarefa(String usuario, String titulo) {
        try {
            List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuario);

            if (tarefas != null) {
                excluirTarefa(tarefas, titulo);
                tarefaRepository.salvarTarefas(tarefas, usuario);
            } else {
                throw new TarefaRemoverException("Não foi possível remover a tarefa.");
            }
        } catch (TarefaRemoverException e) {
            e.printStackTrace();
        }
    }

    public boolean editarTarefa(Tarefa tarefaOriginal, Tarefa tarefaEditada) {
        List<Tarefa> tarefas = TarefaRepository.carregarTarefas(usuarioLogado);

        int indice = tarefas.indexOf(tarefaOriginal);

        if (indice != -1) {
            tarefas.set(indice, tarefaEditada);
            tarefaRepository.salvarTarefas(tarefas, usuarioLogado);

            return true;
        }

        return false;
    }

    public List<Tarefa> listarTarefas(String usuario) {
        return tarefaRepository.carregarTarefas(usuario);
    }

    public List<Tarefa> buscarTarefas(String usuario, String termoBusca) {
        List<Tarefa> tarefas = tarefaRepository.carregarTarefas(usuario);
        return filtrarTarefasPorBusca(tarefas, termoBusca);
    }

    private List<Tarefa> filtrarTarefasPorBusca(List<Tarefa> tarefas, String termoBusca) {
        List<Tarefa> tarefasFiltradas = new ArrayList<>();

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().toLowerCase().contains(termoBusca.toLowerCase()) ||
                    tarefa.getDescricao().toLowerCase().contains(termoBusca.toLowerCase())) {
                tarefasFiltradas.add(tarefa);
            }
        }

        return tarefasFiltradas;
    }

    public void excluirTarefa(List<Tarefa> tarefas, String titulo) {
        try {
            tarefas.removeIf(tarefa -> tarefa.getTitulo().equals(titulo));
            tarefaRepository.salvarTarefas(tarefas, tarefas.get(0).getUsuario());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}