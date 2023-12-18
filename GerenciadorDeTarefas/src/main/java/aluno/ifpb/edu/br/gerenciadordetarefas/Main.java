package aluno.ifpb.edu.br.gerenciadordetarefas;


import aluno.ifpb.edu.br.gerenciadordetarefas.model.Usuario;
import aluno.ifpb.edu.br.gerenciadordetarefas.view.TelaLoginView;

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
            java.util.logging.Logger.getLogger(TelaLoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        TelaLoginView telaLogin = new TelaLoginView();
        telaLogin.setVisible(true);
    }
}
