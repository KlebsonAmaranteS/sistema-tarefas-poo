package aluno.ifpb.edu.br.gerenciadordetarefas.model;

public class Usuario {
    private String usuarioCadastro;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuarioCadastro = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuarioCadastro;
    }

    public String getSenha() {
        return senha;
    }
}