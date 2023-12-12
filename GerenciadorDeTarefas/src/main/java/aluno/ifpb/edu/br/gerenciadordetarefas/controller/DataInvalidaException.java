package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

public class DataInvalidaException extends Exception {
    public DataInvalidaException(String mensagem) {
        super(mensagem);
    }
}
