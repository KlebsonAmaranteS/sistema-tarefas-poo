package aluno.ifpb.edu.br.gerenciadordetarefas.view;

import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaController;
import aluno.ifpb.edu.br.gerenciadordetarefas.controller.TarefaRepository;
import aluno.ifpb.edu.br.gerenciadordetarefas.controller.UsuarioController;
import aluno.ifpb.edu.br.gerenciadordetarefas.model.TarefaService;

import javax.swing.*;

public class TelaLoginView extends javax.swing.JFrame {

    private final TelaPrincipalView tela;
    private final TarefaController tarefaController;
    public static String usuarioLogado;

    private final TarefaRepository tarefaRepository;
    private final TarefaService tarefaService;
    public TelaLoginView() {
        this.tarefaController = new TarefaController();
        this.tarefaRepository = new TarefaRepository();
        this.tarefaService = new TarefaService(tarefaRepository);
        this.tela = new TelaPrincipalView(tarefaController, tarefaRepository, tarefaService);
        initComponents();
        jPasswordFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
    }
    @SuppressWarnings("unchecked")

    private void initComponents() {

        jButtonEntrar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        blusuario = new javax.swing.JLabel();
        lblsenha = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPasswordFieldSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEntrar);
        jButtonEntrar.setBounds(80, 90, 80, 23);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(170, 90, 80, 23);

        blusuario.setText("Usuário");
        getContentPane().add(blusuario);
        blusuario.setBounds(20, 30, 70, 16);

        lblsenha.setText("Senha");
        getContentPane().add(lblsenha);
        lblsenha.setBounds(20, 60, 60, 16);

        jTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(80, 30, 170, 22);

        jButton3.setText("Cadastrar Usuário");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(80, 120, 170, 23);

        jPasswordFieldSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldSenhaKeyPressed(evt);
            }
        });
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(80, 60, 170, 22);

        setSize(new java.awt.Dimension(290, 194));
        setLocationRelativeTo(null);
    }



    private void jTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {
    }


    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        String usuario = jTextFieldUsuario.getText();
        String senha = new String(jPasswordFieldSenha.getPassword());

        if (UsuarioController.realizarLogin(usuario, senha)) {
            usuarioLogado = usuario;
            tela.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Acesso Negado!");
        }
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroView telaCadastro = new TelaCadastroView();
        telaCadastro.setVisible(true);
    }



    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {

    }


    private javax.swing.JLabel blusuario;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JLabel lblsenha;

}