/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 *
 * @author trinh
 */
public class CaroNickname extends javax.swing.JFrame {

    /**
     * Creates new form CaroNickname
     */   
    public CaroNickname() {
        initComponents();            
        setBackground(new java.awt.Color(64, 31, 6));
        setLocationRelativeTo(null);
        tfPlayer1.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
               btOK.doClick();
            }
         }
      });
        tfPlayer2.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_ENTER) {
               btOK.doClick();
            }
         }
      });    
        switch(MenuGame.mode)
        {
            case 1: lbPlayer2.setVisible(false); tfPlayer2.setVisible(false); lbPlayer1.setText("Player"); break;
            case 2: lbPlayer2.setVisible(true); tfPlayer2.setVisible(true);lbPlayer1.setText("Player 1"); break;
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

        tfPlayer1 = new javax.swing.JTextField();
        lbPlayer1 = new javax.swing.JLabel();
        lbPlayer2 = new javax.swing.JLabel();
        tfPlayer2 = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btBack = new javax.swing.JButton();
        lbNotify = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Set Nickname");
        setBackground(new java.awt.Color(64, 31, 6));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);
        setName("formNickname"); // NOI18N

        tfPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPlayer1ActionPerformed(evt);
            }
        });

        lbPlayer1.setText("Player 1");

        lbPlayer2.setText("Player 2");

        tfPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPlayer2ActionPerformed(evt);
            }
        });

        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btBack.setText("Back");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        lbNotify.setText("Nhap nickname cua ban !\n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btOK)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbPlayer2)
                            .addGap(18, 18, 18)
                            .addComponent(tfPlayer2))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbPlayer1)
                            .addGap(18, 18, 18)
                            .addComponent(tfPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lbNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPlayer1)
                    .addComponent(tfPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPlayer2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNotify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBack)
                    .addComponent(btOK))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPlayer2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPlayer2ActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        if (MenuGame.mode == 1 && tfPlayer1.getText().isEmpty() == true){
            //lbNotify.setText("Chưa nhập đủ !!!");            
        }
        else if (MenuGame.mode == 2 && (tfPlayer1.getText().isEmpty() == true || tfPlayer2.getText().isEmpty() == true)){
            lbNotify.setText("Chưa nhập đủ !!!");
            
        }
            else{ 
        setVisible(false);
        InterfaceGame interfa = null; 
        if (MenuGame.mode == 1 )interfa = new InterfaceGame(MenuGame.maxDepth,tfPlayer1.getText(),"COM");
        if (MenuGame.mode == 2 ) interfa = new InterfaceGame(MenuGame.maxDepth,tfPlayer1.getText(),tfPlayer2.getText());
        interfa.setVisible(true);
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
       setVisible(false);
       MenuGame f = new MenuGame(1,1);
       f.setVisible(true);
    }//GEN-LAST:event_btBackActionPerformed

    private void tfPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPlayer1ActionPerformed
        // TODO add your handling code here:
        //setLbPlayer1(new javax.swing.JLabel(getTfPlayer1().getText()));
    }//GEN-LAST:event_tfPlayer1ActionPerformed

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
            java.util.logging.Logger.getLogger(CaroNickname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaroNickname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaroNickname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaroNickname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaroNickname().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btOK;
    private javax.swing.JLabel lbNotify;
    private javax.swing.JLabel lbPlayer1;
    private javax.swing.JLabel lbPlayer2;
    private javax.swing.JTextField tfPlayer1;
    private javax.swing.JTextField tfPlayer2;
    // End of variables declaration//GEN-END:variables

}
