/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Main;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author DANG.TH
 */
public class AboutUs extends javax.swing.JPanel {

     /**
      * Creates new form AboutUs
      */
     public AboutUs() {
	
        //set frame to Center Screen
        Toolkit theKit = this.getToolkit();
        Dimension wndSize = theKit.getScreenSize();
        this.setBounds(wndSize.width / 11, wndSize.height / 11, // Position  
                wndSize.width / 2, wndSize.height / 2); // Size  

	  initComponents();
     }

     /**
      * This method is called from within the constructor to initialize the
      * form. WARNING: Do NOT modify this code. The content of this method is
      * always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          jLabel5 = new javax.swing.JLabel();
          jLabel6 = new javax.swing.JLabel();
          jLabel7 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          jLabel9 = new javax.swing.JLabel();
          jLabel10 = new javax.swing.JLabel();
          jButton1 = new javax.swing.JButton();
          jLabel1 = new javax.swing.JLabel();

          setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
          jLabel2.setForeground(new java.awt.Color(255, 0, 0));
          jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          jLabel2.setText("Abouts Us");
          jLabel2.setToolTipText("");
          add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 190, 50));

          jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          jLabel3.setForeground(new java.awt.Color(0, 0, 204));
          jLabel3.setText("Project : Hệ Thống Quản Lý Bán Vé Xem Phim");
          add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, -1));

          jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          jLabel4.setForeground(new java.awt.Color(0, 0, 153));
          jLabel4.setText("Code By RubikCrew");
          add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

          jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
          jLabel5.setForeground(new java.awt.Color(0, 0, 153));
          jLabel5.setText("Include:");
          add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

          jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
          jLabel6.setText("Phạm Minh Tiền 0974699910 email: tieudao591990@gmai.coml");
          add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

          jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
          jLabel7.setText("Đào Thị Huyền  0974238870 email: huyendth92@gmai.coml");
          add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

          jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
          jLabel8.setText("Trần Hải Đăng  01669927178 email: Haidang92it@gmai.coml");
          add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

          jLabel9.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
          jLabel9.setForeground(new java.awt.Color(255, 51, 51));
          jLabel9.setText("Version : 1.0");
          add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 90, 20));

          jLabel10.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
          jLabel10.setForeground(new java.awt.Color(255, 51, 51));
          jLabel10.setText("Create Date : April 2013");
          add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, 20));

          jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
          jButton1.setForeground(new java.awt.Color(255, 0, 51));
          jButton1.setText("Back");
          jButton1.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
               }
          });
          add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 333, -1, 30));

          jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Main/daisies-on-green-background-871294684597LeG.jpg"))); // NOI18N
          add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, -1));
     }// </editor-fold>//GEN-END:initComponents

     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          // TODO add your handling code here:
	  this.setVisible(false);
	  new MainView().setVisible(true);
     }//GEN-LAST:event_jButton1ActionPerformed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     // End of variables declaration//GEN-END:variables

}
