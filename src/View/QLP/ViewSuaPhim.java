/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.QLP;

import Controller.QLP.Business.AuthenticationBL;
import Controller.QLP.Business.DatabaseConnection;
import Model.Phim;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Administrator
 */
public class ViewSuaPhim extends javax.swing.JFrame {

    ArrayList<Phim> listPhim = new ArrayList<>();
    AuthenticationBL auth = new AuthenticationBL();
    DatabaseConnection data;
    Phim newfilm;
    Phim oldfilm;

    /**
     * Creates new form ViewSuaPhim
     */
    public ViewSuaPhim(Phim p) {//truyen tham so de ViewSuaPhim nhan duoc gia tri truyen vao` tu ViewQLPhim
        initComponents();
        txtMaphim.setText(String.valueOf(p.getMaphim()));
        txtTenphim.setText(p.getTenphim());
        txtDienvien.setText(p.getDienvien());
        txtDaodien.setText(p.getDaodien());
        txtNamsx.setText(String.valueOf(p.getNamsx()));
        txtThoiluong.setText(String.valueOf(p.getThoiluong()));
        txtTheloai.setText(p.getTheloai());
        txtGioithieu.setText(p.getGioithieu());
        try {
            listPhim = auth.dsPhim();
        } catch (Exception e) {
        };
        
        oldfilm = new Phim();
        oldfilm = p;
    }

    private ViewSuaPhim() {
        initComponents();
        listPhim = auth.dsPhim();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGioithieu = new javax.swing.JTextArea();
        txtTheloai = new javax.swing.JTextField();
        txtThoiluong = new javax.swing.JTextField();
        txtNamsx = new javax.swing.JTextField();
        txtDaodien = new javax.swing.JTextField();
        txtDienvien = new javax.swing.JTextField();
        txtTenphim = new javax.swing.JTextField();
        txtMaphim = new javax.swing.JTextField();
        btnSuaPhim = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã Phim");

        jLabel2.setText("Tên Phim");

        jLabel3.setText("Diễn Viên");

        jLabel4.setText("Đạo Diễn");

        jLabel5.setText("Năm SX");

        jLabel6.setText("Thời Lượng");

        jLabel7.setText("Thể Loại");

        jLabel8.setText("Giới Thiệu");

        txtGioithieu.setColumns(20);
        txtGioithieu.setRows(5);
        jScrollPane1.setViewportView(txtGioithieu);

        txtMaphim.setEditable(false);

        btnSuaPhim.setText("Lưu Phim");
        btnSuaPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPhimActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel8)
                    .add(jLabel7)
                    .add(jLabel6)
                    .add(jLabel4)
                    .add(jLabel3)
                    .add(jLabel2)
                    .add(jLabel1)
                    .add(jLabel5))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(txtTenphim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtMaphim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtDienvien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtDaodien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtNamsx, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtThoiluong, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 195, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(46, 46, 46)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtTheloai)
                            .add(layout.createSequentialGroup()
                                .add(btnSuaPhim)
                                .add(18, 18, 18)
                                .add(btnHuy, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                        .add(0, 70, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(txtMaphim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(txtTenphim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(txtDienvien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(txtDaodien, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(txtNamsx, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(19, 19, 19)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel6)
                            .add(txtThoiluong, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jLabel7))
                    .add(txtTheloai, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel8)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSuaPhim)
                    .add(btnHuy))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaPhimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPhimActionPerformed
        auth = new AuthenticationBL();
        newfilm = new Phim(Integer.parseInt(txtMaphim.getText()), txtTenphim.getText(), txtDienvien.getText(),
                txtDaodien.getText(), Integer.parseInt(txtNamsx.getText()), Integer.parseInt(txtThoiluong.getText()),
                txtTheloai.getText(), txtGioithieu.getText());
        if (listPhim.contains(newfilm)) {
            JOptionPane.showMessageDialog(rootPane, "Mã phim đã tồn tại...");
        } else {
            listPhim.add(newfilm);
            if (auth.suaPhim(newfilm, oldfilm) != 0) {
                JOptionPane.showMessageDialog(rootPane, "Sửa phim thành công");
            }
            this.dispose();
            new ViewQLPHIM().setVisible(true);
        }
    }//GEN-LAST:event_btnSuaPhimActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
	new ViewQLPHIM().setVisible(true);
    }//GEN-LAST:event_btnHuyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSuaPhim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDaodien;
    private javax.swing.JTextField txtDienvien;
    private javax.swing.JTextArea txtGioithieu;
    private javax.swing.JTextField txtMaphim;
    private javax.swing.JTextField txtNamsx;
    private javax.swing.JTextField txtTenphim;
    private javax.swing.JTextField txtTheloai;
    private javax.swing.JTextField txtThoiluong;
    // End of variables declaration//GEN-END:variables
}