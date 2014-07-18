/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.QLP;

import Model.Phim;
import java.util.ArrayList;
import javax.swing.UIManager;

/**
 *
 * @author Administrator
 */
public class ThongTinPhim extends javax.swing.JFrame {
    ArrayList<Phim> listP = new ArrayList<>();
    /**
     * Creates new form ThongTinPhim
     */
    public ThongTinPhim(Phim ph) {
        initComponents();
        lblTenphim.setText(ph.getTenphim());
        lblDienvien.setText(ph.getDienvien());
        lblDaodien.setText(ph.getDaodien());
        lblNamsx.setText(String.valueOf(ph.getNamsx()));
        lblThoiluong.setText(String.valueOf(ph.getThoiluong()));
        lblTheloai.setText(ph.getTheloai());
        lblGioithieu.setText(ph.getGioithieu());
        
    }

    private ThongTinPhim() {
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

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblThoiluong = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNamsx = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblGioithieu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTheloai = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTenphim = new javax.swing.JLabel();
        lblDienvien = new javax.swing.JLabel();
        lblDaodien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("The loai");

        jLabel6.setText("Thoi luong");

        lblThoiluong.setText("jLabel14");

        jLabel5.setText("Nam sx");

        lblNamsx.setText("jLabel13");

        jLabel4.setText("Dao dien");

        lblGioithieu.setText("jLabel16");

        jLabel3.setText("Dien vien");

        lblTheloai.setText("jLabel15");

        jLabel2.setText("Ten phim");

        lblTenphim.setText("jLabel10");

        lblDienvien.setText("jLabel11");

        lblDaodien.setText("jLabel12");

        jLabel8.setText("Gioi thieu");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenphim)
                            .addComponent(lblDienvien)
                            .addComponent(lblDaodien))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamsx)
                            .addComponent(lblThoiluong)
                            .addComponent(lblTheloai)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8)
                        .addGap(63, 63, 63)
                        .addComponent(lblGioithieu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTenphim))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblDienvien))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblDaodien)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblNamsx))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblThoiluong))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblTheloai))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblGioithieu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
	new ViewQLPHIM().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblDaodien;
    private javax.swing.JLabel lblDienvien;
    private javax.swing.JLabel lblGioithieu;
    private javax.swing.JLabel lblNamsx;
    private javax.swing.JLabel lblTenphim;
    private javax.swing.JLabel lblTheloai;
    private javax.swing.JLabel lblThoiluong;
    // End of variables declaration//GEN-END:variables
}