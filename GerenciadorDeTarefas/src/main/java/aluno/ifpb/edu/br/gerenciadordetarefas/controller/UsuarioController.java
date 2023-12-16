package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsuarioController {
    private static final String ARQUIVO_USUARIOS = "usuarios.json";
    private static final String CAMPO_USUARIO = "Usuario";
    private static final String CAMPO_SENHA = "Senha";

    private UsuarioController(){

    }

    public static boolean realizarLogin(String usuario, String senha) {
        try {
            if (Files.exists(Paths.get(ARQUIVO_USUARIOS))) {
                String usuariosJson = new String(Files.readAllBytes(Paths.get(ARQUIVO_USUARIOS)));
                JSONArray usuariosArray = new JSONArray(usuariosJson);

                for (int i = 0; i < usuariosArray.length(); i++) {
                    JSONObject usuarioObj = usuariosArray.getJSONObject(i);

                    if (usuarioObj.getString(CAMPO_USUARIO).equals(usuario) &&
                            usuarioObj.getString(CAMPO_SENHA).equals(senha)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void cadastrarUsuario(String usuario, String senha) {
//        try {
//            JSONArray usuariosArray = getUsuariosArray();
//
//            JSONObject novoUsuario = new JSONObject();
//            novoUsuario.put(CAMPO_USUARIO, usuario);
//            novoUsuario.put(CAMPO_SENHA, senha);
//
//            usuariosArray.put(novoUsuario);
//
//            Files.write(Paths.get(ARQUIVO_USUARIOS), usuariosArray.toString().getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static boolean cadastrarUsuario(String usuario, String senha) {
        try {
            JSONArray usuariosArray = getUsuariosArray();

            // Verificar se o usuário já existe
            if (usuarioJaExiste(usuariosArray, usuario)) {
                return false; // Usuário já cadastrado
            }

            JSONObject novoUsuario = new JSONObject();
            novoUsuario.put(CAMPO_USUARIO, usuario);
            novoUsuario.put(CAMPO_SENHA, senha);

            usuariosArray.put(novoUsuario);

            Files.write(Paths.get(ARQUIVO_USUARIOS), usuariosArray.toString().getBytes());
            return true; // Cadastro bem-sucedido
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Falha no cadastro
        }
    }

    private static boolean usuarioJaExiste(JSONArray usuariosArray, String novoUsuario) {
        for (int i = 0; i < usuariosArray.length(); i++) {
            JSONObject usuarioObj = usuariosArray.getJSONObject(i);
            if (usuarioObj.getString(CAMPO_USUARIO).equals(novoUsuario)) {
                return true; // Usuário já existe
            }
        }
        return false; // Usuário não encontrado
    }

    private static JSONArray getUsuariosArray() throws IOException {
        return Files.exists(Paths.get(ARQUIVO_USUARIOS))
                ? new JSONArray(new String(Files.readAllBytes(Paths.get(ARQUIVO_USUARIOS))))
                : new JSONArray();
    }
}
