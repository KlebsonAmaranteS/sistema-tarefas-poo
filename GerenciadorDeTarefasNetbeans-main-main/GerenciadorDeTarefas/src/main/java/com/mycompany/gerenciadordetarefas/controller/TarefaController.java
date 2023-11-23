package main.java.com.mycompany.gerenciadordetarefas.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import main.java.com.mycompany.gerenciadordetarefas.exceptions.DataInvalidaException;
import main.java.com.mycompany.gerenciadordetarefas.model.GerenciadorTarefas;
import main.java.com.mycompany.gerenciadordetarefas.model.Tarefa;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.mycompany.gerenciadordetarefas.model.GerenciadorTarefas.carregarTarefas;

public class TarefaController {
    GerenciadorTarefas gerenciadorTarefa = new GerenciadorTarefas();
    private List<Tarefa> tarefas;

    public String validarData(String data) throws DataInvalidaException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data, formatter);

            if (date.isBefore(LocalDate.now())) {
                throw new DataInvalidaException("A data não pode ser anterior à data atual.");
            }

            return formatter.format(date);
        } catch (DateTimeParseException e) {
            throw new DataInvalidaException("Formato de data inválido. Por favor, insira uma data válida.");
        }
    }

    public void removerTarefa(String usuario, String titulo) {
        List<Tarefa> tarefas = carregarTarefas(usuario);

        if (tarefas != null) {
            tarefas.removeIf(tarefa -> tarefa.getTitulo().equals(titulo));
            gerenciadorTarefa.salvarTarefas(tarefas);
        } else {
            System.err.println("Não foi possível remover tarefa");
        }
    }

    public List<Tarefa> carregarTarefasDoJSON() {
        try (FileReader reader = new FileReader("tarefas.json")) {
            JsonReader jsonReader = new JsonReader(reader);
            jsonReader.setLenient(true);

            Gson gson = new Gson();
            tarefas = gson.fromJson(jsonReader, new TypeToken<ArrayList<Tarefa>>() {}.getType());

            if (tarefas == null) {
                tarefas = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tarefas;
    }
}
