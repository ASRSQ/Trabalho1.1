/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho1;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Saque extends javax.swing.JFrame {
private Contas conta;
private ContaPoupanca cp;
private ContaEspecial cs;
/**
     * Creates new form Saque
     */
    public Saque() {
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sacar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Número da conta:");

        jLabel2.setText("Valor a ser sacado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton2)
                            .addGap(83, 83, 83)
                            .addComponent(jButton1)
                            .addGap(82, 82, 82))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        String u;
        if(Integer.parseInt(jTextField1.getText())==conta.getNumero()){
            JOptionPane.showMessageDialog(null,"Operação de saque realizada com sucesso");
            double o=Double.parseDouble(jTextField2.getText());
           if(o>conta.getSaldo()){ 
               double b= conta.getSaldo();
               double a= conta.getSaldo()+cs.getLimite();
               if(a>=o){
                   cs.setLimite((int)(cp.getSaldo()-o)+cs.getLimite());
                   double c;
                   c=b-o;
                   conta.setSaldo(c+(c*0.1));
                 JOptionPane.showMessageDialog(null,"Saque\n" +"Saque efetuado usando cheque especial"+"\n"+"Nome:"+conta.getNome()+"\n"+"Saldo atual: "+conta.getSaldo());
                 new Final().setVisible(true);
                 dispose();
               }
               else 
               {
                 JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                 new Final().setVisible(true);
                 dispose();
               }
           }
           else{
                u= conta.sacar(Double.parseDouble(jTextField2.getText()));
                JOptionPane.showMessageDialog(null,u+"\n"+"Nome:"+conta.getNome()+"\n"+"Saldo atual:"+conta.getSaldo()+"\n"+"Tipo da conta: "+conta.tipoConta());
                new Final().setVisible(true);
                dispose();
            }
        }
        if(Integer.parseInt(jTextField1.getText())==cp.getNumero()){
            JOptionPane.showMessageDialog(null,"Operação de saque realizada com sucesso");
            double o=Double.parseDouble(jTextField2.getText());
            if(o>cp.getSaldo())
            { 
                    double b= cp.getSaldo();
                    double a= cp.getSaldo()+cs.getLimite();
                    if(a>=o){
                        //cs.setLimite((int)(cp.getSaldo()-o)+cs.getLimite());
                        double c;
                        c=b-o;
                        cp.setSaldo(c+(c*0.1));
                        JOptionPane.showMessageDialog(null,"Saque\n" +"Saque efetuado usando cheque especial"+"\n"+"Nome:"+cp.getNome()+"\n"+"Saldo atual: "+cp.getSaldo()+"\n"+"Tipo da conta: "+cp.tipoconta());
                        new Final().setVisible(true);
                        dispose();

                   }
                    else 
                    {
                        JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                        new Final().setVisible(true);
                        dispose();
                    }
            }
         
            else{
                u= cp.sacar(Double.parseDouble(jTextField2.getText()));
                JOptionPane.showMessageDialog(null,u+"\n"+"Nome:"+cp.getNome()+"\n"+"Saldo atual:"+cp.getSaldo());
                new Final().setVisible(true);
                       dispose();
            }
        }
        if(Integer.parseInt(jTextField1.getText())==cs.getNumero()){
                JOptionPane.showMessageDialog(null,"Operação de saque realizada com sucesso");
                double o=Double.parseDouble(jTextField2.getText());
                if(o>cs.getSaldo()){ 
                    double b= cs.getSaldo();
                    double a= cs.getSaldo()+cs.getLimite();
                    if(a>=o){
                       //cs.setLimite((int)(cs.getSaldo()-o)+cs.getLimite());
                       double c;
                       cs.descontar(o);
                       JOptionPane.showMessageDialog(null,"Saque\n" +"Saque efetuado usando cheque especial"+"\n"+"Nome:"+cs.getNome()+"\n"+"Saldo atual: "+cs.getSaldo());  
                       new Final().setVisible(true);
                       dispose();
                    }
                    else 
                    {
                      JOptionPane.showMessageDialog(null,"Saldo insuficiente");
                      new Final().setVisible(true);
                      dispose();
                    }
                }        
                else{
                        u= cs.sacar(Double.parseDouble(jTextField2.getText()));
                        JOptionPane.showMessageDialog(null,u+"\n"+"Nome:"+cs.getNome()+"\n"+"Saldo atual:"+cs.getSaldo()+"\n"+"Tipo da conta:"+cs.tipoConta());}
                        new Final().setVisible(true);
                        dispose();
            }
    if( Integer.parseInt(jTextField1.getText())!=cp.getNumero() && Integer.parseInt(jTextField1.getText())!=conta.getNumero()&& Integer.parseInt(jTextField1.getText())!=cs.getNumero() ){
        JOptionPane.showMessageDialog(null, "Conta inexistente");
        new Final().setVisible(true);
        dispose();    
    }
    }//GEN-LAST:event_jButton2ActionPerformed

         
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Operação cancelada");
        new Final().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
     private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        // TODO add your handling code here:
        new Final().setVisible(true);
    }                         
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
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Saque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Saque().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}