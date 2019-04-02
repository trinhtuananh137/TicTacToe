
package main;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class About extends javax.swing.JFrame {

  
    public About() {
        initComponents();
        setTitle("About");
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

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(64, 31, 6));
        setForeground(new java.awt.Color(64, 31, 6));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(64, 31, 6));
        jTextField1.setFont(new java.awt.Font("VNI-Palatin", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(254, 254, 174));
        jTextField1.setText("About Us");
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 110, 30));

        jScrollPane1.setForeground(new java.awt.Color(254, 254, 174));

        jTextArea1.setBackground(new java.awt.Color(64, 31, 6));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("VNI-Univer", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(254, 254, 174));
        jTextArea1.setRows(5);
        jTextArea1.setText("Thaønh vieân:  - Trònh Tuaán Anh\n\t-  Minh Chaâu\n\t-  Nguyeãn Ñaït\n\t- Nguyeãn Thaønh Coâng\n\t\n\t         \n\t           Teân phaàn meàm: Caro Battle\n\t      \n\t                   Naêm phaùt haønh: 2019");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 400, 240));

        jButton1.setBackground(new java.awt.Color(254, 254, 174));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 60, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/panelBackground.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 390));

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
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
