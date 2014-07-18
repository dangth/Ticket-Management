/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.QLPC;

import Controller.QLP.Business.AuthenticationBL;
import Model.PhongChieu;
import View.Main.MainView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author TranHaiDang
 */
public final class ViewQLPC extends javax.swing.JFrame {

     ArrayList<PhongChieu> listPC = new ArrayList<>();
     PhongChieu pc;
     AuthenticationBL auth = new AuthenticationBL();

     ;

    /**
     * Creates new form ViewQLPC
     */
    public ViewQLPC() {
	  //Title
	  this.setTitle("QUẢN LÝ PHÒNG CHIẾU - PHẠM MINH TIẾN_TEAM 1");
	  //set frame to Center Screen
	  Toolkit theKit = this.getToolkit();
	  Dimension wndSize = theKit.getScreenSize();
	  this.setBounds(wndSize.width / 11, wndSize.height / 11, // Position  
		  wndSize.width / 2, wndSize.height / 2); // Size  

	  //set icon
	  try {
	       BufferedImage image;
	       image = ImageIO.read(this.getClass().getResource("/Images/Icons/icon232x32.png"));
	       this.setIconImage(image);
	  } catch (IOException ex) {
	       Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  initComponents();
	  pc = new PhongChieu();

	  listPC = auth.dsPhongChieu();
	  taoBangPhongChieu();
     }

     public void taoBangPhongChieu() {
	  listPC = new AuthenticationBL().dsPhongChieu();
	  if (listPC.size() == 0) {
	       JOptionPane.showMessageDialog(null, "Không có Phòng chiếu nào trong CSDL!! Xin Cảm ơn");
	  } else {
	       DefaultTableModel m = (DefaultTableModel) tblPhongchieu.getModel();
	       m.getDataVector().removeAllElements();
	       m.fireTableDataChanged();
	       TableRowSorter sorter = new TableRowSorter(m);
	       tblPhongchieu.setRowSorter(sorter);

	       for (PhongChieu i : listPC) {
		    m.addRow(i.toArray());
	       }
	  }
     }

     /**
      * This method is called from within the constructor to initialize the
      * form. WARNING: Do NOT modify this code. The content of this method is
      * always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          jPanel5 = new javax.swing.JPanel();
          cbTheloai = new javax.swing.JComboBox();
          jPanel2 = new javax.swing.JPanel();
          txtPC = new javax.swing.JTextField();
          tbnTimkiem = new javax.swing.JButton();
          jScrollPane2 = new javax.swing.JScrollPane();
          tblPhongchieu = new javax.swing.JTable();
          BtnTLC = new javax.swing.JButton();
          BtnSLC = new javax.swing.JButton();
          BtnXLC = new javax.swing.JButton();
          BtnTV = new javax.swing.JButton();
          BGQLLC = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setBackground(new java.awt.Color(255, 255, 255));
          getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

          jPanel1.setBackground(new java.awt.Color(255, 255, 255));

          jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm thể loại phim", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 102, 204))); // NOI18N

          cbTheloai.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
          cbTheloai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2D", "3D" }));
          cbTheloai.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbTheloaiActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
          jPanel5.setLayout(jPanel5Layout);
          jPanel5Layout.setHorizontalGroup(
               jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          jPanel5Layout.setVerticalGroup(
               jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE))
          );

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm theo tên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 102, 204))); // NOI18N

          txtPC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
          txtPC.setForeground(new java.awt.Color(204, 204, 204));
          txtPC.setText("Nhập thông tin phòng chiếu ...");
          txtPC.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    txtPCMouseClicked(evt);
               }
          });
          txtPC.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtPCKeyReleased(evt);
               }
          });

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtPC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE))
          );

          tbnTimkiem.setText("Tìm kiếm");
          tbnTimkiem.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tbnTimkiemActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbnTimkiem)
                    .addGap(23, 23, 23))
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(0, 1, Short.MAX_VALUE))
                         .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(34, 34, 34)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(tbnTimkiem)
                    .addContainerGap(193, Short.MAX_VALUE))
          );

          getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 150, 270, 470));

          tblPhongchieu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
          tblPhongchieu.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {

               },
               new String [] {
                    "Mã phòng chiếu", "Tên phòng chiếu", "Số lượng ghế", "Thể loại phòng"
               }
          ) {
               boolean[] canEdit = new boolean [] {
                    false, false, false, false
               };

               public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
               }
          });
          jScrollPane2.setViewportView(tblPhongchieu);

          getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 850, 460));

          BtnTLC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BtnTPC.png"))); // NOI18N
          BtnTLC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          BtnTLC.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BtnTPC2.png"))); // NOI18N
          BtnTLC.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BtnTLCActionPerformed(evt);
               }
          });
          getContentPane().add(BtnTLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 680, 160, 40));

          BtnSLC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BtnSPC.png"))); // NOI18N
          BtnSLC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          BtnSLC.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BtnSPC2.png"))); // NOI18N
          BtnSLC.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BtnSLCActionPerformed(evt);
               }
          });
          getContentPane().add(BtnSLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 680, 160, 40));

          BtnXLC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BtnXPC.png"))); // NOI18N
          BtnXLC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          BtnXLC.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BtnXPC2.png"))); // NOI18N
          BtnXLC.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BtnXLCActionPerformed(evt);
               }
          });
          getContentPane().add(BtnXLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 680, 160, 40));

          BtnTV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BtnTV.png"))); // NOI18N
          BtnTV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
          BtnTV.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    BtnTVActionPerformed(evt);
               }
          });
          getContentPane().add(BtnTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 680, 160, 40));

          BGQLLC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/QLPC/BGQLPC.png"))); // NOI18N
          getContentPane().add(BGQLLC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 730));

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void BtnTLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTLCActionPerformed
	 // TODO add your handling code here:
	 new ViewThemPC().setVisible(true);
    }//GEN-LAST:event_BtnTLCActionPerformed

    private void BtnSLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSLCActionPerformed
	 // TODO add y()our handling code here:
	 //kiem tra dk neu click vao 1 hang cua bang
	 if (tblPhongchieu.getSelectedRow() == 0) {
	      JOptionPane.showMessageDialog(null, "Hãy chọn phong chieu cần sửa.", "     : : : Warning : : :", JOptionPane.ERROR_MESSAGE);
	 } else {
	      int row = tblPhongchieu.getSelectedRow();
	      //1 doi tuong duoc chon se duoc truy suat den phuong thuc timPhongChieu() 
	      //de gui thong tin ve form ViewSuaPC
	      PhongChieu phongc = timPhongChieu(tblPhongchieu.getValueAt(row, 0).toString());
	      int j = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sửa phong chieu : " + phongc.getTenphong(), "::: Update Data ::: !", 2);
	      if (j == 0) {
		   new ViewSuaPC(phongc).setVisible(true);
		   this.dispose();
	      }
	 }

    }//GEN-LAST:event_BtnSLCActionPerformed

    private void BtnTVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTVActionPerformed
	 // TODO add your handling code here:
	 MainView main = new MainView();
	 main.setVisible(true);
	 this.dispose();
    }//GEN-LAST:event_BtnTVActionPerformed

    private void BtnXLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnXLCActionPerformed
	 // TODO add your handling code here:
	 if (tblPhongchieu.getSelectedRowCount() == 0) {
	      JOptionPane.showMessageDialog(null, "Hãy chọn Phòng cần xóa khỏi CSDL ",
		      "     : : : Warning : : :", JOptionPane.ERROR_MESSAGE);
	 } else {
	      int row = tblPhongchieu.getSelectedRow();  // Hang duoc chon trong bang Vé\

	      int j = JOptionPane.showConfirmDialog(null,
		      "Bạn chắc chắn muốn xóa thông tin Phòng chiếu này không? ",
		      "::: Update Data ::: !", 2);
	      if (j == 0) {
		   new AuthenticationBL().xoaPhongchieu(Integer.parseInt(
			   tblPhongchieu.getValueAt(row, 0).toString()));
		   JOptionPane.showMessageDialog(null, "Xoa Phòng chiếu thanh cong!");
		   taoBangPhongChieu();

	      }
	 }
    }//GEN-LAST:event_BtnXLCActionPerformed

    private void cbTheloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTheloaiActionPerformed
	 // TODO add your handling code here:
    }//GEN-LAST:event_cbTheloaiActionPerformed

    private void txtPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPCMouseClicked
	 // TODO add your handling code here:
	 txtPC.setText("");
	 txtPC.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtPCMouseClicked

    private void txtPCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPCKeyReleased
	 TimKiemPhim();
    }//GEN-LAST:event_txtPCKeyReleased

    private void tbnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnTimkiemActionPerformed
	 timTheloai();
    }//GEN-LAST:event_tbnTimkiemActionPerformed
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel BGQLLC;
     private javax.swing.JButton BtnSLC;
     private javax.swing.JButton BtnTLC;
     private javax.swing.JButton BtnTV;
     private javax.swing.JButton BtnXLC;
     private javax.swing.JComboBox cbTheloai;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel5;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JTable tblPhongchieu;
     private javax.swing.JButton tbnTimkiem;
     private javax.swing.JTextField txtPC;
     // End of variables declaration//GEN-END:variables

     public PhongChieu timPhongChieu(String maPC) {//gui thong tin tu bang? = pp truyen tham so
	  PhongChieu pc = new PhongChieu();
	  for (PhongChieu i : listPC) {//kiem tra thong tin phim trong list danh sach phim
	       if (i.getMaphong() == Integer.parseInt(maPC)) {//so sanh 2 doi tuong neu 
		    pc = i;
	       }
	  }
	  return pc;
     }

     public void TimKiemPhim() {
	  TableModel absModel = (TableModel) tblPhongchieu.getModel();
	  TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(absModel);
	  tblPhongchieu.setRowSorter(sorter);
	  String text = txtPC.getText();
	  try {
	       sorter.setRowFilter(RowFilter.regexFilter(text));
	  } catch (PatternSyntaxException pse) {
	       System.err.println("Bad regex pattern");
	  }
     }

     public void timTheloai() {
	  TableModel absModel = (TableModel) tblPhongchieu.getModel();
	  TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(absModel);
	  tblPhongchieu.setRowSorter(sorter);
	  String text = cbTheloai.getSelectedItem().toString();
	  try {
	       sorter.setRowFilter(RowFilter.regexFilter(text));
	  } catch (PatternSyntaxException pse) {
	       System.err.println("Bad regex pattern");
	  }
     }
}
