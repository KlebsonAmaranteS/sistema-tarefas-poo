package aluno.ifpb.edu.br.gerenciadordetarefas.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TarefaRepository {
    private static final String CAMINHO_ARQUIVO_JSON = "tarefas.json";
    private static final String MSG_ERRO_LEITURA = "Erro ao carregar tarefas do arquivo JSON.";
    private static final String MSG_ERRO_ESCRITA = "Erro ao salvar tarefas no arquivo JSON.";

    public static List<Tarefa> carregarTarefas(String usuario) {
        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO_JSON)) {
            TypeToken<List<Tarefa>> token = new TypeToken<>() {};
            List<Tarefa> todasAsTarefas = new Gson().fromJson(reader, token.getType());

            if (todasAsTarefas == null) {
                todasAsTarefas = new ArrayList<>();
            }

            return todasAsTarefas.stream()
                    .filter(tarefa -> tarefa.getUsuario().equals(usuario))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(MSG_ERRO_LEITURA);
            return new ArrayList<>();
        }
    }

    public void salvarTarefas(List<Tarefa> tarefas) {
        try (FileWriter writer = new FileWriter(CAMINHO_ARQUIVO_JSON)) {
            new Gson().toJson(tarefas, writer);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(MSG_ERRO_ESCRITA);
        }
    }
}
