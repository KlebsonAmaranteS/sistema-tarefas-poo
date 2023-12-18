package aluno.ifpb.edu.br.gerenciadordetarefas.model;

public class Usuario {
    private String usuarioCadastrado;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuarioCadastrado = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuarioCadastrado;
    }

    public void setUsuario(String usuarioCadastrado) {
        this.usuarioCadastrado = usuarioCadastrado;
    }

    public String getSenha() {
        return senha;
    }
}