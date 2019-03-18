package main;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class MenuGame extends javax.swing.JFrame {

    private InterfaceGame interfa;
    private Settings level;
    public static int maxDepth;
    public static int mode;
    
    public MenuGame(int depth,int _mode) {
        initComponents();
        setTitle("Caro Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
        this.maxDepth = depth;
        this.mode = _mode;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btNewGame = new javax.swing.JButton();
        btAbout = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btHelp = new javax.swing.JButton();
        btOption = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Caro");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btNewGame.setBackground(new java.awt.Color(255, 204, 0));
        btNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/btNewGame.png"))); // NOI18N
        btNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewGameActionPerformed(evt);
            }
        });
        getContentPane().add(btNewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 180, 40));

        btAbout.setBackground(new java.awt.Color(255, 204, 0));
        btAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/btAbout.png"))); // NOI18N
        btAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAboutActionPerformed(evt);
            }
        });
        getContentPane().add(btAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 100, 40));

        btExit.setBackground(new java.awt.Color(255, 204, 0));
        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/btExit.png"))); // NOI18N
        btExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btExit.setFocusable(false);
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        getContentPane().add(btExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 120, 40));

        btHelp.setBackground(new java.awt.Color(255, 204, 0));
        btHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/btHelp.png"))); // NOI18N
        btHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 100, 40));

        btOption.setBackground(new java.awt.Color(255, 204, 0));
        btOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/btSettings.png"))); // NOI18N
        btOption.setToolTipText("");
        btOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOptionActionPerformed(evt);
            }
        });
        getContentPane().add(btOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/lbGameCaro.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 330, 120));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/panelBackground.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 390));

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewGameActionPerformed
        setVisible(false);
        interfa = new InterfaceGame(maxDepth);        
        interfa.setVisible(true);
    }//GEN-LAST:event_btNewGameActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void btHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHelpActionPerformed
       
        Help help = new Help();
        help.setVisible(true);
    }//GEN-LAST:event_btHelpActionPerformed

    private void btOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOptionActionPerformed
        
        level = new Settings();
        level.setVisible(true);
    }//GEN-LAST:event_btOptionActionPerformed

    private void btAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAboutActionPerformed
        
        About about = new About();
        about.setVisible(true);
    }//GEN-LAST:event_btAboutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbout;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btHelp;
    private javax.swing.JButton btNewGame;
    private javax.swing.JButton btOption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
