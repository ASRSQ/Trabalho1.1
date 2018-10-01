/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho1;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Transferir extends javax.swing.JFrame {

    /**
     * Creates new form Trasferir
     */
    private Contas conta;
    private ContaPoupanca cp;
    private ContaEspecial cs;
    public Transferir() {
        initComponents();
        conta=Contas.getInstancia();
        cp= ContaPoupanca.getInstancia1();
        cs= ContaEspecial.getInstancia1();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Número da conta a enviar dinheiro:");

        jLabel2.setText("Número da conta a receber dinheiro:");

        jButton1.setText("Transferir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor :");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel3))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        double a;
        if(Integer.parseInt(jTextField2.getText())==cp.getNumero()||Integer.parseInt(jTextField2.getText())==cs.getNumero()||Integer.parseInt(jTextField2.getText())==conta.getNumero() ){
            if(Integer.parseInt(jTextField1.getText())==cp.getNumero()||Integer.parseInt(jTextField1.getText())==cs.getNumero()||Integer.parseInt(jTextField1.getText())==conta.getNumero() ){    
                    if(Integer.parseInt(jTextField1.getText())==conta.getNumero()){
                        a= conta.transferir(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText()),Double.parseDouble(jTextField3.getText()));
                        if(a!=0)
                        {
                            JOptionPane.showMessageDialog(null, "Trasnferência Realizada com sucesso");
                            if(Integer.parseInt(jTextField2.getText())==cs.getNumero()){
                                  cs.depositar(a);
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+conta.getNumero()+": "+conta.getSaldo()+"\n"+"Titular: "+conta.getNome());
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+cs.getNumero()+": "+cs.getSaldo()+"\n"+"Titular: "+cs.getNome());
                                  new Final().setVisible(true);
                                  dispose();
                            }
                            if(Integer.parseInt(jTextField2.getText())==cp.getNumero()){
                                  cp.depositar(a);
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+conta.getNumero()+": "+conta.getSaldo()+"\n"+"Titular: "+conta.getNome());
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+cp.getNumero()+": "+cp.getSaldo()+"\n"+"Titular: "+cp.getNome());
                                  new Final().setVisible(true);
                                  dispose();
                            }
                         }
                        else 
                        {
                            JOptionPane.showMessageDialog(null,"Erro na opereção");
                            JOptionPane.showMessageDialog(null,"Conta "+conta.getNumero()+" não tem saldo suficinte");
                            new Final().setVisible(true);
                            dispose();
                        }
                    }
                    if(Integer.parseInt(jTextField1.getText())==cp.getNumero()){
                        a= cp.transferir(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText()),Double.parseDouble(jTextField3.getText()));
                        if(a!=0){
                                JOptionPane.showMessageDialog(null, "Trasnferência Realizada com sucesso");
                            if(Integer.parseInt(jTextField2.getText())==conta.getNumero()){
                                  conta.depositar(a);
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+cp.getNumero()+": "+cp.getSaldo()+"\n"+"Titular: "+cp.getNome());
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+conta.getNumero()+": "+conta.getSaldo()+"\n"+"Titular: "+conta.getNome());
                                  new Final().setVisible(true);
                                  dispose();
                            }
                            if(Integer.parseInt(jTextField2.getText())==cs.getNumero()){
                                  cs.depositar(a);
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+cp.getNumero()+": "+cp.getSaldo()+"\n"+"Titular: "+cp.getNome());
                                  JOptionPane.showMessageDialog(null,"Saldo atual conta "+cs.getNumero()+": "+cs.getSaldo()+"\n"+"Titular: "+cs.getNome());
                                  new Final().setVisible(true);
                                  dispose();
                            }
                        }
                        else 
                        {
                            JOptionPane.showMessageDialog(null,"Erro na opereção");
                            JOptionPane.showMessageDialog(null,"Conta "+cp.getNumero()+" não tem saldo suficinte");
                            new Final().setVisible(true);
                            dispose();
                        }
                    }  
                    if(Integer.parseInt(jTextField1.getText())==cs.getNumero()){
                       a= cs.transferir(Integer.parseInt(jTextField1.getText()),Integer.parseInt(jTextField2.getText()),Double.parseDouble(jTextField3.getText()));
                       if(a!=0){
                        JOptionPane.showMessageDialog(null, "Trasnferência Realizada com sucesso");
                        if(Integer.parseInt(jTextField2.getText())==conta.getNumero()){
                              conta.depositar(a);
                              JOptionPane.showMessageDialog(null,"Saldo atual conta "+cs.getNumero()+": "+cs.getSaldo()+"\n"+"Titular: "+cs.getNome());
                              JOptionPane.showMessageDialog(null,"Saldo atual conta "+conta.getNumero()+": "+conta.getSaldo()+"\n"+"Titular: "+conta.getNome());
                              new Final().setVisible(true);
                              dispose();
                        }
                        if(Integer.parseInt(jTextField2.getText())==cp.getNumero()){
                              cp.depositar(a);
                              JOptionPane.showMessageDialog(null,"Saldo atual conta "+cs.getNumero()+": "+cs.getSaldo()+"\n"+"Titular: "+cs.getNome());
                              JOptionPane.showMessageDialog(null,"Saldo atual conta "+cp.getNumero()+": "+cp.getSaldo()+"\n"+"Titular: "+cp.getNome());
                              new Final().setVisible(true);
                              dispose();
                            }
                        }
                       else 
                       {
                           JOptionPane.showMessageDialog(null,"Erro na opereção");
                           JOptionPane.showMessageDialog(null,"Conta "+cp.getNumero()+" não tem saldo suficinte");
                           new Final().setVisible(true);
                            dispose();
                       }
                    }
            }        
            else{
                JOptionPane.showMessageDialog(null,"Conta a enviar não encontrada");
                new Final().setVisible(true);
                dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Conta a receber não encontrada");
            new Final().setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Operação cancelada");
        new Final().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(Transferir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transferir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transferir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transferir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transferir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
