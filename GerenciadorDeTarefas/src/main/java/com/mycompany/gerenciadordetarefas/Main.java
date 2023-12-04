package com.mycompany.gerenciadordetarefas;

import com.mycompany.gerenciadordetarefas.controller.TarefaController;
import com.mycompany.gerenciadordetarefas.controller.TarefaRepository;
import com.mycompany.gerenciadordetarefas.model.TarefaService;
import com.mycompany.gerenciadordetarefas.view.TelaLogin;

public class Main {
    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        TarefaRepository tarefaRepository = new TarefaRepository();
        TarefaService tarefaService = new TarefaService(tarefaRepository);
        TarefaController tarefaController = new TarefaController(tarefaRepository, tarefaService);

        TelaLogin telaLogin = new TelaLogin(tarefaRepository, tarefaController, tarefaService);
        telaLogin.setVisible(true);
    }
}
