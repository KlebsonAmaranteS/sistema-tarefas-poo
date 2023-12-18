package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

public class NenhumaTarefaException extends Exception {
    public NenhumaTarefaException() {
        super("Nenhuma tarefa para listar");
    }
}
