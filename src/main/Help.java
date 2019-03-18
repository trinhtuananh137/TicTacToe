
package main;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Help extends javax.swing.JFrame {
    
    public Help() {
        initComponents();
        setTitle("Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("/res/icon.png"));
        Image image = icon.getImage();
        setIconImage(image);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(64, 31, 6));
        setFocusCycleRoot(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(64, 31, 6));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("VNI-Meli", 1, 20)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(254, 254, 174));
        jTextArea1.setRows(5);
        jTextArea1.setText("- Choïn ñoä khoù vaø cheá ñoä chôi trong muïc\nSettings\n\nLuaät chôi:\nDaønh chieán thaéng tröôùc ñoái thuû baèng\ncaùch taïo ra moät haøng ngang, haøng doïc\nhoaëc moät haøng cheùo goàm 5 quaân côø\n\nEnjoy this game <3 \n");
        jTextArea1.setBorder(null);
        jTextArea1.setCaretColor(new java.awt.Color(64, 31, 6));
        jTextArea1.setDisabledTextColor(new java.awt.Color(64, 31, 6));
        jTextArea1.setSelectionColor(new java.awt.Color(64, 31, 6));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 410, 290));

        jButton1.setBackground(new java.awt.Color(254, 254, 174));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/panelBackground.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 380));
        jLabel1.getAccessibleContext().setAccessibleParent(this);

        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
