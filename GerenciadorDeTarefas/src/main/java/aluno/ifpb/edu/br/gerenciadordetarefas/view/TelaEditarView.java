package aluno.ifpb.edu.br.gerenciadordetarefas.view;

import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaController;
import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaRepository;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.Usuario;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static aluno.ifpb.edu.br.gerenciadordetarefas.view.TelaLoginView.usuarioLogado;

public class TelaEditarView extends javax.swing.JFrame {
    private final TelaPrincipalView telaPrincipal;
    private final Tarefa tarefaParaEditar;
    private Usuario usuarioCadastrado;
    private final TarefaRepository tarefaPersistence;

    private TarefaController tarefaController;

    public TelaEditarView(TelaPrincipalView telaPrincipal, boolean modal, Tarefa tarefaParaEditar) {

        initComponents();
        this.telaPrincipal = telaPrincipal;
        this.tarefaParaEditar = tarefaParaEditar;
        this.usuarioCadastrado = new Usuario("", "");
        this.tarefaPersistence = new TarefaRepository();
        this.tarefaController = new TarefaController();
        preencherCampos();
        configurarGruposBotoes();


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        javax.swing.JTextArea jTextAreaDescricao;
        javax.swing.JFormattedTextField jFormattedTextFieldDataConclusao;
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jList1 = new javax.swing.JList<>();
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
                try {
                    jButton2ActionPerformed(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
    }// </editor-fold>//GEN-END:initComponents


    private void preencherCampos() {
        jTextFieldTitulo.setText(tarefaParaEditar.getTitulo());
        jTextArea1.setText(tarefaParaEditar.getDescricao());
        jFormattedTextFieldData.setText(tarefaParaEditar.getDataConclusao());

    }
    private void configurarGruposBotoes() {
        buttonGroup1.add(jRadioButtonNaoConcluida);
        buttonGroup1.add(jRadioButtonConcluida);
        buttonGroup2.add(jRadioButtonBaixa);
        buttonGroup2.add(jRadioButtonMedia);
        buttonGroup2.add(jRadioButtonAlta);
    }

    private void jTextFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jFormattedTextFieldDataActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (camposPreenchidos()) {
                Tarefa tarefaEditada = criarTarefaEditada();

                if (validarOpcoesSelecionadas()) {
                    if (tarefaController.editarTarefa(tarefaParaEditar, tarefaEditada)) {
                        JOptionPane.showMessageDialog(this, "Tarefa editada com sucesso!");
                        dispose();
                        atualizarListaETelaPrincipal();
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro ao editar a tarefa. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, selecione uma opção para Status e Importância.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean camposPreenchidos() {
        return !jTextFieldTitulo.getText().isEmpty() &&
                !jTextArea1.getText().isEmpty() &&
                !jFormattedTextFieldData.getText().isEmpty();
    }


    private Tarefa criarTarefaEditada() {
        return new Tarefa(
                usuarioCadastrado.getNomeUsuario(),
                jTextFieldTitulo.getText(),
                jTextArea1.getText(),
                jFormattedTextFieldData.getText(),
                jRadioButtonConcluida.isSelected(),
                obterImportanciaSelecionada()
        );
    }

    private boolean validarOpcoesSelecionadas() {
        return (jRadioButtonNaoConcluida.isSelected() || jRadioButtonConcluida.isSelected()) &&
                (jRadioButtonBaixa.isSelected() || jRadioButtonMedia.isSelected() || jRadioButtonAlta.isSelected());
    }

    private String obterImportanciaSelecionada() {
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


    private void atualizarListaETelaPrincipal() throws IOException {
        List<Tarefa> tarefas = Objects.requireNonNull(TarefaRepository.carregarTarefas(usuarioLogado));
        telaPrincipal.atualizarListaTarefas(tarefas);
    }



    private javax.swing.JList<Tarefa> jList1;
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