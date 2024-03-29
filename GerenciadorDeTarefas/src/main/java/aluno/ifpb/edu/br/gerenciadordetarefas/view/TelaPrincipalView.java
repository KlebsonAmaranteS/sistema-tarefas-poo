package aluno.ifpb.edu.br.gerenciadordetarefas.view;


import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaController;
import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaRepository;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.Tarefa;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static aluno.ifpb.edu.br.gerenciadordetarefas.view.TelaLoginView.usuarioLogado;

public class TelaPrincipalView extends javax.swing.JFrame {
    private final TarefaController tarefaController;
    private final TarefaRepository tarefaRepository;
    private List<Tarefa> tarefas;
    private final JFrame frame;

    private static final String MENSAGEM_CONFIRMACAO_SAIR = "Tem certeza que deseja sair?";
    private static final String MENSAGEM_CONFIRMACAO_REMOVER_TAREFA = "Tem certeza que deseja remover a tarefa?";
    private static final String MENSAGEM_CONFIRMACAO_EDITAR_TAREFA = "Tem certeza que deseja editar a tarefa?";
    private static final String MENSAGEM_NENHUMA_TAREFA_SELECIONADA_EDITAR = "Nenhuma tarefa selecionada para editar.";
    private static final String MENSAGEM_NENHUMA_TAREFA_DISPONIVEL = "Nenhuma tarefa disponível para remover.";
    private static final String MENSAGEM_NENHUMA_TAREFA_SELECIONADA_REMOVER = "Nenhuma tarefa selecionada para remover.";
    private static final String MENSAGEM_NENHUMA_TAREFA_LISTAR = "Nenhuma tarefa para listar";


    public TelaPrincipalView(TarefaController tarefaController, TarefaRepository tarefaRepository) {
        initComponents();
        this.tarefas = new ArrayList<>();
        this.frame = new JFrame("Sistema tarefas");
        this.tarefaController = tarefaController;
        this.tarefaRepository = tarefaRepository;
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                try {
                    List<Tarefa> tarefas = tarefaController.listarTarefas(usuarioLogado);
                    atualizarListaTarefas(tarefas);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frame, "Erro ao listar tarefas: " + e.getMessage());
                }
            }
        });
    }


    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButtonCriarTarefa = new javax.swing.JButton();
        jButtonEditarTarefa = new javax.swing.JButton();
        jButtonRemoverTarefa = new javax.swing.JButton();
        jTextFieldBuscarTarefa = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButtonRemoverTarefa1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);


        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });



        jList1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jList1.setModel(new AbstractListModel<Tarefa>() {
            Tarefa[] strings = {};

            public int getSize() {
                return strings.length;
            }

            public Tarefa getElementAt(int i) {
                return strings[i];
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonCriarTarefa.setText("Criar Tarefa");
        jButtonCriarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarTarefaActionPerformed(evt);
            }
        });

        jButtonEditarTarefa.setText("Editar Tarefa");
        jButtonEditarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonEditarTarefaActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButtonRemoverTarefa.setText("Remover Tarefa");
        jButtonRemoverTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonRemoverTarefaActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jTextFieldBuscarTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jTextFieldBuscarTarefaActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar Tarefa");

        jButton2.setText("Buscar");

        jButtonRemoverTarefa1.setText("Listar Tarefas");
        jButtonRemoverTarefa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonListarTarefa1ActionPerformed(evt);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SwingUtilities.invokeLater(() -> {
                    try {
                        jButtonBuscarActionPerformed(evt);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButtonRemoverTarefa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonCriarTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonEditarTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonRemoverTarefa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldBuscarTarefa))
                                                .addGap(20, 20, 20))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addGap(41, 41, 41))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jButtonCriarTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditarTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverTarefa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverTarefa1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBuscarTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(36, 36, 36)
                                .addComponent(jButton1)
                                .addContainerGap())
        );

        setSize(new java.awt.Dimension(585, 330));
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int opcao = JOptionPane.showConfirmDialog(this, MENSAGEM_CONFIRMACAO_SAIR, "Confirmação", JOptionPane.YES_NO_OPTION);

        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }


    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String termoBusca = jTextFieldBuscarTarefa.getText().trim();

            if (termoBusca.isEmpty()) {
                EventQueue.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Digite um termo de busca", "Busca de Tarefas", JOptionPane.INFORMATION_MESSAGE);
                });
            } else {
                List<Tarefa> tarefasFiltradas = tarefaController.buscarTarefas(usuarioLogado, termoBusca);

                EventQueue.invokeLater(() -> {
                    if (tarefasFiltradas.isEmpty()) {
                        String mensagem = "Nenhuma tarefa encontrada para o termo: " + termoBusca;
                        JOptionPane.showMessageDialog(this, mensagem, "Busca de Tarefas", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        atualizarListaTarefas(tarefasFiltradas);
                    }
                });
            }
        } catch (Exception e) {
            EventQueue.invokeLater(() -> {
                JOptionPane.showMessageDialog(this, "Erro ao buscar tarefas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            });
        }
    }



    private void jButtonEditarTarefaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        int selectedIndex = jList1.getSelectedIndex();

        if (selectedIndex != -1) {
            Tarefa tarefaSelecionada = obterTarefaSelecionada(selectedIndex);

            int opcao = JOptionPane.showConfirmDialog(this, MENSAGEM_CONFIRMACAO_EDITAR_TAREFA, "Confirmação", JOptionPane.YES_NO_OPTION);

            if (opcao == JOptionPane.YES_OPTION) {
                TelaEditarView telaEdicao = new TelaEditarView(this, true, tarefaSelecionada);
                telaEdicao.setVisible(true);
                tarefaController.listarTarefas(usuarioLogado);
            }
        } else {
            JOptionPane.showMessageDialog(frame, MENSAGEM_NENHUMA_TAREFA_SELECIONADA_EDITAR);
        }
    }

    private Tarefa obterTarefaSelecionada(int selectedIndex) {
        DefaultListModel<Tarefa> model = (DefaultListModel<Tarefa>) jList1.getModel();

        if (selectedIndex >= 0 && selectedIndex < model.size()) {
            return model.getElementAt(selectedIndex);
        }
        JOptionPane.showMessageDialog(frame, "Nenhuma tarefa foi selecionada");
        return null;
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        SwingUtilities.invokeLater(() -> {
            try {
                jButtonBuscarActionPerformed(evt);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }



    private void jButtonRemoverTarefaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        int selectedIndex = jList1.getSelectedIndex();

        if (selectedIndex != -1) {
            Tarefa selectedTask = obterTarefaSelecionada(selectedIndex);

            if (selectedTask != null) {
                int opcao = JOptionPane.showConfirmDialog(this, MENSAGEM_CONFIRMACAO_REMOVER_TAREFA, "Confirmação", JOptionPane.YES_NO_OPTION);

                if (opcao == JOptionPane.YES_OPTION) {
                    DefaultListModel<Tarefa> model = (DefaultListModel<Tarefa>) jList1.getModel();

                    if (selectedIndex < model.getSize()) {
                        model.remove(selectedIndex);
                        tarefaController.removerTarefa(usuarioLogado, selectedTask.getTitulo());
                        tarefas.remove(selectedTask);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(frame, MENSAGEM_NENHUMA_TAREFA_DISPONIVEL);
            }
        } else {
            JOptionPane.showMessageDialog(frame, MENSAGEM_NENHUMA_TAREFA_SELECIONADA_REMOVER);
        }
    }



    private void jTextFieldBuscarTarefaActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
    }



    private void jButtonCriarTarefaActionPerformed(java.awt.event.ActionEvent evt) {
        TarefaView telaCadastro = new TarefaView(tarefaController);
        dispose();
        telaCadastro.setVisible(true);

    }

    private void jButtonListarTarefa1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        try {
            List<Tarefa> tarefas = tarefaController.listarTarefas(usuarioLogado);

            if (tarefas.isEmpty()) {
                JOptionPane.showMessageDialog(frame, MENSAGEM_NENHUMA_TAREFA_LISTAR);
            } else {
                atualizarListaTarefas(tarefas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Erro ao listar tarefas: " + e.getMessage());
        }
    }


    void atualizarListaTarefas(List<Tarefa> tarefas) {
        SwingUtilities.invokeLater(() -> {
            DefaultListModel<Tarefa> model = new DefaultListModel<>();
            for (Tarefa tarefa : tarefas) {
                model.addElement(tarefa);
            }
            jList1.setModel(model);
        });
    }



    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCriarTarefa;
    private javax.swing.JButton jButtonEditarTarefa;
    private javax.swing.JButton jButtonRemoverTarefa;
    private javax.swing.JButton jButtonRemoverTarefa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Tarefa> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldBuscarTarefa;

    private javax.swing.JButton jButtonBuscar;
}
