/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.aluno;

import aula.Simulado;
import dao.alunoDAO;
import dao.configDAO;
import dao.simuladoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.Config;
import negocio.Matricula;
import pessoa.Aluno;

/**
 *
 * @author adowt
 */
public class SimuladoAlunoView extends javax.swing.JDialog {
    ArrayList<Simulado> simuList;
    Aluno alunoAtual;
    Config conf;
    /**
     * Creates new form SimuladoAlunoView
     */
    public SimuladoAlunoView(java.awt.Frame parent, boolean modal, Aluno aluReceber) {
        super(parent, modal);
        initComponents();
        this.alunoAtual = aluReceber;
        try {
            conf = new configDAO().buscar();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jSimuTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSimData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jMarcarSim = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPrecoAula = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSaldoAluno = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSaldoFinal = new javax.swing.JLabel();
        jRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Seus simulados:");

        jSimuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Simulado", "Data", "Resultado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jSimuTable);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Marcar Simulado"));

        jLabel2.setText("Data:");

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("*DD/MM/AA");

        jMarcarSim.setText("Marcar");
        jMarcarSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMarcarSimActionPerformed(evt);
            }
        });

        jLabel7.setText("Será cobrado R$");

        jPrecoAula.setText("300");

        jLabel10.setText("Você tem R$");

        jSaldoAluno.setText("1200");

        jLabel12.setText("em saldo");

        jLabel13.setText("pelo simulado");

        jLabel14.setText("Você irá ficar com R$");

        jSaldoFinal.setText("900");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jSimData, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPrecoAula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSaldoAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSaldoFinal)))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMarcarSim)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSimData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jMarcarSim)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jSaldoAluno)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jPrecoAula)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jSaldoFinal))
                        .addGap(54, 54, 54))))
        );

        jRemover.setText("Remover");
        jRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                    .addComponent(jRemover))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRemover)
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshTable(){
        try {
            DefaultTableModel tabSim = (DefaultTableModel) jSimuTable.getModel();
            
            while(tabSim.getRowCount()!=0){
                tabSim.removeRow(0);
            }
            
            Simulado simuPro = new Simulado(0, "", -1, conf.getPrecoSimulado());
            simuList = new simuladoDAO().procurar(simuPro, alunoAtual);
            
            for(Simulado simuAdd:simuList){
                if(simuAdd.getResultado() > -1){
                    tabSim.addRow(new Object[]{simuAdd.getId(), simuAdd.getData(), simuAdd.getResultado()});
                } else {
                    tabSim.addRow(new Object[]{simuAdd.getId(), simuAdd.getData(), "Ainda não avaliado"});
                }
            }
            Config conf = new configDAO().buscar();
            //Seta os valores
            
            jSaldoAluno.setText(Float.toString(alunoAtual.getMatricula().getSaldo()));
            jPrecoAula.setText(Float.toString(conf.getPrecoSimulado()));
            float saldoFinal = alunoAtual.getMatricula().getSaldo() - conf.getPrecoSimulado();
            jSaldoFinal.setText(Float.toString(saldoFinal));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        refreshTable();          
        
    }//GEN-LAST:event_formWindowOpened

    private void jRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverActionPerformed
        try {
            int linhSelec = jSimuTable.getSelectedRow();
            
            Simulado simRemov = simuList.get(linhSelec);
            
            Matricula matNova = new Matricula(alunoAtual.getMatricula().getNumero(), alunoAtual.getMatricula().getSaldo());                
            matNova.setSaldo(matNova.getSaldo()-conf.getPrecoAula());
            alunoAtual.setMatricula(matNova);
            new alunoDAO().alterar(alunoAtual, alunoAtual);
            
            if(simRemov.getResultado() > -1){
                new simuladoDAO().apagar(simRemov, alunoAtual);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Não é possível remover simulados já realizados!");
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }
    }//GEN-LAST:event_jRemoverActionPerformed

    private void jMarcarSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMarcarSimActionPerformed
        try {
            if(jSimData.getText() != ""){
                Simulado simuAdd = new Simulado(0, jSimData.getText(), -1, conf.getPrecoSimulado());

                new simuladoDAO().inserir(simuAdd, alunoAtual);

                Matricula matNova = new Matricula(alunoAtual.getMatricula().getNumero(), alunoAtual.getMatricula().getSaldo());

                matNova.setSaldo(matNova.getSaldo()-conf.getPrecoAula());
                alunoAtual.setMatricula(matNova);
                new alunoDAO().alterar(alunoAtual, alunoAtual);

                JOptionPane.showMessageDialog(this, "Simulado adicionado com sucesso!");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Digite uma data!");
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Erro na conexão!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro no banco!\n"+ex.getMessage());
        }

    }//GEN-LAST:event_jMarcarSimActionPerformed

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
            java.util.logging.Logger.getLogger(SimuladoAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimuladoAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimuladoAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimuladoAlunoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SimuladoAlunoView dialog = new SimuladoAlunoView(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jMarcarSim;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jPrecoAula;
    private javax.swing.JButton jRemover;
    private javax.swing.JLabel jSaldoAluno;
    private javax.swing.JLabel jSaldoFinal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSimData;
    private javax.swing.JTable jSimuTable;
    // End of variables declaration//GEN-END:variables
}
