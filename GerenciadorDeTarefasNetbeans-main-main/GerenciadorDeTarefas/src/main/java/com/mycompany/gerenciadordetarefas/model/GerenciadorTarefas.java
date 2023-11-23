package main.java.com.mycompany.gerenciadordetarefas.model;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorTarefas {
    public static final String CAMINHO_ARQUIVO_JSON = "tarefas.json";

    public static List<Tarefa> carregarTarefas(String usuario) {
        try (FileReader reader = new FileReader(CAMINHO_ARQUIVO_JSON)) {
            TypeToken<List<Tarefa>> token = new TypeToken<List<Tarefa>>() {};
            List<Tarefa> todasAsTarefas = new Gson().fromJson(reader, token.getType());

            return todasAsTarefas.stream()
                    .filter(tarefa -> tarefa.getUsuario().equals(usuario))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void salvarTarefas(List<Tarefa> tarefas) {
        try (FileWriter writer = new FileWriter(GerenciadorTarefas.CAMINHO_ARQUIVO_JSON)) {
            new Gson().toJson(tarefas, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Tarefa obterTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = carregarTarefas(usuario);

        if (tarefas != null) {
            return tarefas.stream()
                    .filter(tarefa -> tarefa.getTitulo().equals(titulo))
                    .findFirst()
                    .orElse(null);
        } else {
            return null;
        }
    }

    public Tarefa[] toArray(Tarefa[] tarefas) {
        return tarefas;
    }
}