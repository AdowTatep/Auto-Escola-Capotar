/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.atendente;

import dao.alunoDAO;
import dao.usuarioDAO;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import negocio.Matricula;
import pessoa.Aluno;
import pessoa.Pessoa;

/**
 *
 * @author aluno
 */
public class PagamentoView extends javax.swing.JDialog {

    
    ArrayList<Pessoa> listaAlu = new ArrayList<>();//Cria uma lista para preencher com a busca
    /**
     * Creates new form PagamentoView
     */
    public PagamentoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCPF = new javax.swing.JTextField();
        jLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jAlunos = new javax.swing.JComboBox();
        jPagar = new javax.swing.JPanel();
        jNomeAluno = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jInserirPagamento = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSaldoAluno = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSaldoNovo = new javax.swing.JTextField();
        jPesquisar = new javax.swing.JButton();
        jAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Pesquisa:");

        jLabel2.setText("Nome: ");

        jLabel3.setText("CPF:");

        jLabel4.setText("Login: ");

        jAlunos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Faça uma busca!" }));
        jAlunos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jAlunosItemStateChanged(evt);
            }
        });

        jNomeAluno.setText("NOME");

        jLabel5.setText("Saldo atual de");

        jInserirPagamento.setText("Inserir Pagamento");
        jInserirPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInserirPagamentoActionPerformed(evt);
            }
        });

        jLabel6.setText(":");

        jSaldoAluno.setText("SALDO");

        jLabel8.setText("Saldo a ser inserido em R$:");

        jSaldoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaldoNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPagarLayout = new javax.swing.GroupLayout(jPagar);
        jPagar.setLayout(jPagarLayout);
        jPagarLayout.setHorizontalGroup(
            jPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPagarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInserirPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSaldoNovo)
                    .addGroup(jPagarLayout.createSequentialGroup()
                        .addGroup(jPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPagarLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNomeAluno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSaldoAluno))
                            .addComponent(jLabel8))
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPagarLayout.setVerticalGroup(
            jPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPagarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jNomeAluno)
                    .addComponent(jLabel6)
                    .addComponent(jSaldoAluno))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSaldoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jInserirPagamento)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPesquisar.setText("Pesquisar");
        jPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPesquisarActionPerformed(evt);
            }
        });

        jAtualizar.setText("Att");
        jAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jCPF))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jNome)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPesquisar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPesquisar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPesquisarActionPerformed
        try {
            
            //Cria uma pessoa para inserir no dao da busca
            Pessoa pessoaPesq;
            pessoaPesq = new Pessoa(jLogin.getText(), "", jNome.getText(), jCPF.getText(), "Aluno");             
            
            //Cria o dao usu para fazer a busca
            usuarioDAO dao = new usuarioDAO();
            
            //preenche a lista com o resultado dos alunos
            listaAlu = dao.procurar(pessoaPesq);
            
            //Pega o model da combo e bota em uma variável para fácil uso
            DefaultComboBoxModel cbModel = (DefaultComboBoxModel) jAlunos.getModel();
            
            //Remove os elementos dentro da combo box
            cbModel.removeAllElements();
            
            //Adiciona o texto "ecolha um aluno"
            cbModel.addElement("Escolha um aluno");
            
            //cria um foreach para cada aluno na lista
            for (Pessoa pessAdd:listaAlu) { 
                //adiciona cada pessoa na combo box
                cbModel.addElement(pessAdd.getNome()+". CPF: "+ pessAdd.getCpf());
            }            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!/n"+ex.getMessage());
        }
    }//GEN-LAST:event_jPesquisarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jPagar.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void jAlunosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jAlunosItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jAlunosItemStateChanged

    private void jAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtualizarActionPerformed
        try {
            //Cria um aluno passando a pessoa selecionada
            Aluno alu = new Aluno(listaAlu.get(jAlunos.getSelectedIndex()-1));
            
            //Cria a dao para buscar um aluno
            alunoDAO aluDAO = new alunoDAO();
            
            if(aluDAO.getByLoginSenha(alu) != null){
                //Busca um aluno usando o aluno selecionado
                //para poder pegar o saldo corretamente
                alu = aluDAO.getByLoginSenha(alu);
            }
            
            //Modifica o nome e o saldo do aluno para aparecer no painel            
            jNomeAluno.setText(alu.getNome());
            jSaldoAluno.setText(Float.toString(alu.getMatricula().getSaldo()));
            
            //Deixa o painel visível
            jPagar.setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!/n"+ex.getMessage());
        }
    }//GEN-LAST:event_jAtualizarActionPerformed

    private void jInserirPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInserirPagamentoActionPerformed
        try {
            //Converte o número digitado para float
            float saldoNovo = Float.parseFloat(jSaldoNovo.getText());
            
            //Cria um aluno passando a pessoa selecionada
            Aluno alu = new Aluno(listaAlu.get(jAlunos.getSelectedIndex()-1), 0, saldoNovo);
            
            //Cria a dao aluno para ser usada
            alunoDAO aluDAO = new alunoDAO();
            
            //Se já existir um aluno na tabela aluno_matricula
            //quer dizer que ele já foi matriculado e quer somente
            //adicionar mais crédito à sua conta
            if(aluDAO.getByLoginSenha(alu)!=null){
                //Busca o aluno
                alu = aluDAO.getByLoginSenha(alu);
                
                //Altera o saldo desse aluno já somando com o saldo
                //já existente
                alu.getMatricula().setSaldo(alu.getMatricula().getSaldo() + saldoNovo);
                //Altera passando o novo saldo
                aluDAO.alterar(alu);
            }else{
                //Senão existir ele insere um novo                
                aluDAO.inserir(alu);
                //Pega o aluno atualizado
                alu = aluDAO.getByLoginSenha(alu);
            }
            
            JOptionPane.showMessageDialog(this, "Saldo adicionado!\n"
                    + "Seu número de matrícula de "+alu.getNome()+" é: "+alu.getMatricula().getNumero());
            
            //Some com o painel
            jPagar.setVisible(false);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
        
    }//GEN-LAST:event_jInserirPagamentoActionPerformed

    private void jSaldoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaldoNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSaldoNovoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PagamentoView dialog = new PagamentoView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jAlunos;
    private javax.swing.JButton jAtualizar;
    private javax.swing.JTextField jCPF;
    private javax.swing.JButton jInserirPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jLogin;
    private javax.swing.JTextField jNome;
    private javax.swing.JLabel jNomeAluno;
    private javax.swing.JPanel jPagar;
    private javax.swing.JButton jPesquisar;
    private javax.swing.JLabel jSaldoAluno;
    private javax.swing.JTextField jSaldoNovo;
    // End of variables declaration//GEN-END:variables
}
