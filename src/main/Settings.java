package main;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Settings extends javax.swing.JFrame {

    public static final int DEPTH_EASY = 1;
    public static final int DEPTH_MEDIUM = 5;
    public static final int DEPTH_HARD = 11;
    
    public Settings() {
        initComponents();
        setTitle("Level");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
        switch(MenuGame.maxDepth){
            case DEPTH_EASY: this.btEasy.setBackground(new java.awt.Color(225,225,225));break;
            case DEPTH_MEDIUM: this.btMedium.setBackground(new java.awt.Color(225,225,225));break;
            case DEPTH_HARD: this.btHard.setBackground(new java.awt.Color(225,225,225));break;
        }
        switch(MenuGame.mode){
            case 1: this.btCom.setBackground(new java.awt.Color(225,225,225));break;
            case 2: this.btHuman.setBackground(new java.awt.Color(225,225,225));break;
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        levelLable = new javax.swing.JLabel();
        btEasy = new javax.swing.JButton();
        btCom = new javax.swing.JButton();
        btHuman = new javax.swing.JButton();
        btMedium = new javax.swing.JButton();
        btHard = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 174));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mode");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 80, 50));

        levelLable.setBackground(new java.awt.Color(255, 255, 255));
        levelLable.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        levelLable.setForeground(new java.awt.Color(254, 254, 174));
        levelLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        levelLable.setText("Level Play");
        getContentPane().add(levelLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 140, 40));

        btEasy.setBackground(new java.awt.Color(254, 254, 174));
        btEasy.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btEasy.setForeground(new java.awt.Color(64, 31, 6));
        btEasy.setText("Easy");
        btEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEasyActionPerformed(evt);
            }
        });
        getContentPane().add(btEasy, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 80, 60));

        btCom.setBackground(new java.awt.Color(254, 254, 174));
        btCom.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btCom.setForeground(new java.awt.Color(64, 31, 6));
        btCom.setText("COM");
        btCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComActionPerformed(evt);
            }
        });
        getContentPane().add(btCom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 110, 41));

        btHuman.setBackground(new java.awt.Color(254, 254, 174));
        btHuman.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btHuman.setForeground(new java.awt.Color(64, 31, 6));
        btHuman.setText("HUMAN");
        btHuman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHumanActionPerformed(evt);
            }
        });
        getContentPane().add(btHuman, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 110, 41));

        btMedium.setBackground(new java.awt.Color(254, 254, 174));
        btMedium.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btMedium.setForeground(new java.awt.Color(64, 31, 6));
        btMedium.setText("Medium");
        btMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMediumActionPerformed(evt);
            }
        });
        getContentPane().add(btMedium, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 100, 60));

        btHard.setBackground(new java.awt.Color(254, 254, 174));
        btHard.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        btHard.setForeground(new java.awt.Color(64, 31, 6));
        btHard.setText("Hard");
        btHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHardActionPerformed(evt);
            }
        });
        getContentPane().add(btHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 100, 60));

        jButton1.setBackground(new java.awt.Color(254, 254, 174));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/panelBackground.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 400));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEasyActionPerformed
        MenuGame.maxDepth = DEPTH_EASY;
        btEasy.setBackground(new java.awt.Color(225,225,225));
        btMedium.setBackground(new java.awt.Color(254,254,174));
        btHard.setBackground(new java.awt.Color(254,254,174));
        
    }//GEN-LAST:event_btEasyActionPerformed

    private void btMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMediumActionPerformed
       MenuGame.maxDepth = DEPTH_MEDIUM;
       btEasy.setBackground(new java.awt.Color(254,254,174));
        btMedium.setBackground(new java.awt.Color(225,225,225));
        btHard.setBackground(new java.awt.Color(254,254,174)); 
    }//GEN-LAST:event_btMediumActionPerformed

    private void btHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHardActionPerformed
        MenuGame.maxDepth = DEPTH_HARD;
        btEasy.setBackground(new java.awt.Color(254,254,174));
        btMedium.setBackground(new java.awt.Color(254,254,174));
        btHard.setBackground(new java.awt.Color(225,225,225)); 
    }//GEN-LAST:event_btHardActionPerformed

    private void btComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComActionPerformed
        levelLable.setVisible(true);
        btEasy.setVisible(true);
        btMedium.setVisible(true);
        btHard.setVisible(true);
        MenuGame.mode = 1;
        btCom.setBackground(new java.awt.Color(225,225,225));
        btHuman.setBackground(new java.awt.Color(254,254,174));        
        
    }//GEN-LAST:event_btComActionPerformed

    private void btHumanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHumanActionPerformed
        levelLable.setVisible(false);
        btEasy.setVisible(false);
        btMedium.setVisible(false);
        btHard.setVisible(false);
        MenuGame.mode = 2;
        btHuman.setBackground(new java.awt.Color(225,225,225));
        btCom.setBackground(new java.awt.Color(254,254,174));
        
    }//GEN-LAST:event_btHumanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCom;
    private javax.swing.JButton btEasy;
    private javax.swing.JButton btHard;
    private javax.swing.JButton btHuman;
    private javax.swing.JButton btMedium;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel levelLable;
    // End of variables declaration//GEN-END:variables
}
