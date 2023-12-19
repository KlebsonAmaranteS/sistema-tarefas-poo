package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import aluno.ifpb.edu.br.gerenciadordetarefas.model.Usuario;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class UsuarioController {

    private static final String ARQUIVO_USUARIOS = "usuarios.json";
    private static final String CAMPO_USUARIO = "Usuario";
    private static final String CAMPO_SENHA = "Senha";

    private UsuarioController() {}

    public static boolean realizarLogin(Usuario usuario, Usuario senha) {
        try {
            JSONArray usuariosArray = getUsuariosArray();

            for (int i = 0; i < usuariosArray.length(); i++) {
                JSONObject usuarioObj = usuariosArray.getJSONObject(i);

                if (usuarioObj.getString(CAMPO_USUARIO).equals(usuario.getNomeUsuario()) &&
                        usuarioObj.getString(CAMPO_SENHA).equals(senha.getSenha())) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     return false;
    }


    private static boolean usuarioJaExiste(JSONArray usuariosArray, String novoUsuario) {
        for (int i = 0; i < usuariosArray.length(); i++) {
            JSONObject usuarioObj = usuariosArray.getJSONObject(i);
            if (usuarioObj.getString(CAMPO_USUARIO).equals(novoUsuario)) {
                return true;
            }
        }
        return false;
    }

    private static JSONArray getUsuariosArray() throws IOException {
        return Files.exists(Paths.get(ARQUIVO_USUARIOS))
                ? new JSONArray(new String(Files.readAllBytes(Paths.get(ARQUIVO_USUARIOS))))
                : new JSONArray();
    }

    public static boolean cadastrarUsuario(String usuario, String senha) {
        try {
            JSONArray usuariosArray = getUsuariosArray();

            if (usuarioJaExiste(usuariosArray, usuario)) {
                return false;
            }

            JSONObject novoUsuario = new JSONObject();
            novoUsuario.put(CAMPO_USUARIO, usuario);
            novoUsuario.put(CAMPO_SENHA, senha);

            usuariosArray.put(novoUsuario);

            Files.write(Paths.get(ARQUIVO_USUARIOS), usuariosArray.toString().getBytes());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
