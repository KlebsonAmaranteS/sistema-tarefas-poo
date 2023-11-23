package main.java.com.mycompany.gerenciadordetarefas.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.java.com.mycompany.gerenciadordetarefas.controller.TarefaController;
import main.java.com.mycompany.gerenciadordetarefas.exceptions.DataInvalidaException;
import main.java.com.mycompany.gerenciadordetarefas.model.Tarefa;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static main.java.com.mycompany.gerenciadordetarefas.view.TelaLogin.usuarioLogado;

public class InterfaceTarefa extends javax.swing.JFrame {

    private List<Tarefa> tarefas;
    public InterfaceTarefa() {

        tarefas = new ArrayList<>();
        initComponents();
        buttonGroup1.add(jRadioButtonNaoConcluida);
        buttonGroup1.add(jRadioButtonConcluida);
        buttonGroup2.add(jRadioButtonBaixa);
        buttonGroup2.add(jRadioButtonMedia);
        buttonGroup2.add(jRadioButtonAlta);
    }



    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButtonNaoConcluida = new javax.swing.JRadioButton();
        jRadioButtonConcluida = new javax.swing.JRadioButton();
        jRadioButtonBaixa = new javax.swing.JRadioButton();
        jRadioButtonMedia = new javax.swing.JRadioButton();
        jRadioButtonAlta = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de cliente ");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Importância");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 190, 120, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Título da tarefa");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 90, 16);

        jTextFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTituloActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTitulo);
        jTextFieldTitulo.setBounds(10, 28, 240, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Descrição da Tarefa");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 60, 120, 16);

        jFormattedTextFieldData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldDataActionPerformed(evt);
            }
        });
        getContentPane().add(jFormattedTextFieldData);
        jFormattedTextFieldData.setBounds(20, 210, 64, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Data de Conclusão");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 190, 120, 16);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Status da Tarefa");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 190, 120, 16);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(440, 350, 72, 23);

        jButton2.setText("Concluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 350, 73, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 500, 86);

        jRadioButtonNaoConcluida.setText("Não Concluida");
        getContentPane().add(jRadioButtonNaoConcluida);
        jRadioButtonNaoConcluida.setBounds(180, 210, 110, 21);

        jRadioButtonConcluida.setText("Concluida");
        getContentPane().add(jRadioButtonConcluida);
        jRadioButtonConcluida.setBounds(180, 230, 76, 21);

        jRadioButtonBaixa.setText("Baixa");
        getContentPane().add(jRadioButtonBaixa);
        jRadioButtonBaixa.setBounds(350, 210, 60, 21);

        jRadioButtonMedia.setText("Media");
        getContentPane().add(jRadioButtonMedia);
        jRadioButtonMedia.setBounds(350, 230, 70, 21);

        jRadioButtonAlta.setText("Alta");
        getContentPane().add(jRadioButtonAlta);
        jRadioButtonAlta.setBounds(350, 250, 70, 21);

        setSize(new java.awt.Dimension(564, 431));
        setLocationRelativeTo(null);
    }

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            this.dispose();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            cadastrarTarefa(usuarioLogado);
            salvarTarefasEmJSON(usuarioLogado);
            this.dispose();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Por favor, insira uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (DataInvalidaException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.atualizarListaTarefas(tarefas);
    }

    public void cadastrarTarefa(String usuario) throws ParseException, DataInvalidaException {
        TarefaController tarefaController = new TarefaController();
        Tarefa novaTarefa = new Tarefa(
                usuario,
                jTextFieldTitulo.getText(),
                jTextArea1.getText(),
                tarefaController.validarData(jFormattedTextFieldData.getText()),
                jRadioButtonConcluida.isSelected(),
                obterImportanciaSelecionada()
        );

        tarefas.add(novaTarefa);

        JOptionPane.showMessageDialog(this, "Tarefa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.atualizarListaTarefas(tarefas);
    }
    private void salvarTarefasEmJSON(String usuario) {
        TarefaController tarefaController = new TarefaController();
        List<Tarefa> tarefasExistente = tarefaController.carregarTarefasDoJSON();

        Tarefa novaTarefa = new Tarefa(
                usuario,
                jTextFieldTitulo.getText(),
                jTextArea1.getText(),
                jFormattedTextFieldData.getText(),
                jRadioButtonConcluida.isSelected(),
                obterImportanciaSelecionada()
        );

        tarefasExistente.add(novaTarefa);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(tarefasExistente);

        try (FileWriter writer = new FileWriter("tarefas.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String obterImportanciaSelecionada() {
        if (jRadioButtonBaixa.isSelected()) {
            return "Baixa";
        } else if (jRadioButtonMedia.isSelected()) {
            return "Média";
        } else if (jRadioButtonAlta.isSelected()) {
            return "Alta";
        } else {
            return "";
        }
    }

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButtonAlta;
    private javax.swing.JRadioButton jRadioButtonBaixa;
    private javax.swing.JRadioButton jRadioButtonConcluida;
    private javax.swing.JRadioButton jRadioButtonMedia;
    private javax.swing.JRadioButton jRadioButtonNaoConcluida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldTitulo;

}