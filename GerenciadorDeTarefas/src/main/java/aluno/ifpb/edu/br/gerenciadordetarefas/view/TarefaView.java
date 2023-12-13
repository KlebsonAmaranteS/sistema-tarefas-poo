package aluno.ifpb.edu.br.gerenciadordetarefas.view;

import aluno.ifpb.edu.br.gerenciadordetarefas.controller.DataInvalidaException;
import aluno.ifpb.edu.br.gerenciadordetarefas.controller.DataValidator;
import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaController;
import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaRepository;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.TarefaService;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static aluno.ifpb.edu.br.gerenciadordetarefas.view.TelaLoginView.usuarioLogado;

public class TarefaView extends javax.swing.JFrame {
    private final TarefaController tarefaController;
    private List<Tarefa> tarefas;
    private final TarefaRepository tarefaPersistence;
    private final TarefaService tarefaService;
    private final TelaPrincipalView telaPrincipal;

    public TarefaView(TarefaController tarefaController) {
        this.tarefaController = new TarefaController();
        this.tarefaPersistence = new TarefaRepository();
        this.tarefaService = new TarefaService(tarefaPersistence);
        this.telaPrincipal = new TelaPrincipalView(tarefaController, tarefaPersistence, tarefaService);
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel1.setText("Importância");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 190, 120, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12));
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
        } catch (DataInvalidaException | IOException e) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Por favor, insira uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

//    public void cadastrarTarefa(String usuario) throws DataInvalidaException, IOException {
//        String titulo = jTextFieldTitulo.getText();
//        String descricao = jTextArea1.getText();
//        String dataConclusao = jFormattedTextFieldData.getText();
//
//        if (titulo.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Por favor, forneça um título para a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        if (descricao.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Por favor, forneça uma descrição para a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        if (dataConclusao.trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Por favor, forneça uma data de conclusão para a tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        try {
//            DataValidator.validarData(dataConclusao);
//        } catch (DataInvalidaException e) {
//            JOptionPane.showMessageDialog(this, "Formato de data inválido. Por favor, insira uma data válida.", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        if (!jRadioButtonConcluida.isSelected() && !jRadioButtonNaoConcluida.isSelected()) {
//            JOptionPane.showMessageDialog(this, "Por favor, selecione o status da tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        if (!jRadioButtonBaixa.isSelected() && !jRadioButtonMedia.isSelected() && !jRadioButtonAlta.isSelected()) {
//            JOptionPane.showMessageDialog(this, "Por favor, selecione a importância da tarefa.", "Erro", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        else {
//            Tarefa novaTarefa = new Tarefa(
//                    usuario,
//                    titulo,
//                    descricao,
//                    DataValidator.validarData(dataConclusao),
//                    jRadioButtonConcluida.isSelected(),
//                    obterImportanciaSelecionada()
//            );
//
//            tarefaController.cadastrarTarefa(novaTarefa);
//
//            JOptionPane.showMessageDialog(this, "Tarefa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
//        }}

    public void cadastrarTarefa(String usuario) throws DataInvalidaException, IOException {
        String titulo = jTextFieldTitulo.getText();
        String descricao = jTextArea1.getText();
        String dataConclusao = jFormattedTextFieldData.getText();

        try {
            validateInput(titulo, descricao, dataConclusao);
        } catch (DataInvalidaException | IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Tarefa novaTarefa = new Tarefa(
                usuario,
                titulo,
                descricao,
                DataValidator.validarData(dataConclusao),
                jRadioButtonConcluida.isSelected(),
                obterImportanciaSelecionada()
        );

        tarefaController.cadastrarTarefa(novaTarefa);

        JOptionPane.showMessageDialog(this, "Tarefa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void validateInput(String titulo, String descricao, String dataConclusao)
            throws DataInvalidaException, IllegalArgumentException {
        if (titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, forneça um título para a tarefa.");
        }

        if (descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, forneça uma descrição para a tarefa.");
        }

        if (dataConclusao.trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, forneça uma data de conclusão para a tarefa.");
        }

        DataValidator.validarData(dataConclusao);

        if (!jRadioButtonConcluida.isSelected() && !jRadioButtonNaoConcluida.isSelected()) {
            throw new IllegalArgumentException("Por favor, selecione o status da tarefa.");
        }

        if (!jRadioButtonBaixa.isSelected() && !jRadioButtonMedia.isSelected() && !jRadioButtonAlta.isSelected()) {
            throw new IllegalArgumentException("Por favor, selecione a importância da tarefa.");
        }
    }

    private void salvarTarefasEmJSON(String usuario) throws IOException {

        List<Tarefa> tarefasExistente = TarefaRepository.carregarTarefas(usuario);

        Tarefa novaTarefa = new Tarefa(
                usuario,
                jTextFieldTitulo.getText(),
                jTextArea1.getText(),
                jFormattedTextFieldData.getText(),
                jRadioButtonConcluida.isSelected(),
                obterImportanciaSelecionada()
        );

        tarefasExistente.add(novaTarefa);
        tarefaPersistence.salvarTarefas(tarefasExistente);
        telaPrincipal.atualizarListaTarefas(tarefasExistente);

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