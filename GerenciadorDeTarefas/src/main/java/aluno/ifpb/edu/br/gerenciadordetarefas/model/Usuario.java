package aluno.ifpb.edu.br.gerenciadordetarefas.model;



public class Usuario {
    private String senha;
    private String usuarioCadastrado;

    public Usuario(String usuario, String senha) {
        this.usuarioCadastrado = usuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return usuarioCadastrado;
    }

    public void setUsuario(String usuarioCadastrado) {
        this.usuarioCadastrado = usuarioCadastrado;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }

}