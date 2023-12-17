package aluno.ifpb.edu.br.gerenciadordetarefas.model;

public class Usuario {
<<<<<<< HEAD
    private String usuarioCadastrado;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuarioCadastrado = usuario;
=======
    private String usuarioCadastro;
    private String senha;

    public Usuario(String usuario, String senha) {
        this.usuarioCadastro = usuario;
>>>>>>> 3a908b151b33b218a4344de0913dc3e3dc718cf2
        this.senha = senha;
    }

    public String getUsuario() {
<<<<<<< HEAD
        return usuarioCadastrado;
=======
        return usuarioCadastro;
>>>>>>> 3a908b151b33b218a4344de0913dc3e3dc718cf2
    }

    public String getSenha() {
        return senha;
    }
}