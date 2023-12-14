package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaRepository {
    private static final String CAMINHO_ARQUIVO_JSON = "tarefas.json";

    public static List<Tarefa> carregarTarefas(String usuario) {
        try (FileReader reader = new FileReader(getCaminhoArquivo(usuario))) {
            TypeToken<List<Tarefa>> token = new TypeToken<>() {};
            List<Tarefa> todasAsTarefas = new Gson().fromJson(reader, token.getType());

            if (todasAsTarefas == null) {
                todasAsTarefas = new ArrayList<>();
            }

            return todasAsTarefas;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private static String getCaminhoArquivo(String usuario) {
        return "tarefas_" + usuario + ".json";
    }


    public void salvarTarefas(List<Tarefa> todasAsTarefas, String usuario) {
        try (FileWriter writer = new FileWriter(getCaminhoArquivo(usuario))) {
            new Gson().toJson(todasAsTarefas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}