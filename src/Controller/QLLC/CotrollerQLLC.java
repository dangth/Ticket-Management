/**
 * Projectname Quản Lý Bán Vé Xem Phim Package Controller.QLLC ClassName
 * ControllerQLLC
 *
 * @author RubikCrew
 * @Version 1.0 April 2013
 */
package Controller.QLLC;

import Controller.QLLC.ConnectionDB.ConnectionDB;
import Controller.QLLC.ConnectionDB.ConnectionDBFactory;
import Model.LichChieu;
import Model.Phim;
import Model.PhongChieu;
import View.Main.MainView;
import View.QLLC.ViewDSLichChieu;
import View.QLLC.ViewSuaLichChieu;
import View.QLLC.ViewThemLichChieu;
import com.sun.rowset.JdbcRowSetImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.Soundbank;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import sun.org.mozilla.javascript.internal.ast.WhileLoop;

/**
 * Lớp Định nghĩa phương thức điều khiển quản lý lịch chiếu bao gồm các chức
 * năng điều khiển kết nối CSDL Microsoft SQL server 2008 điều khiển chức năng
 * Thêm lịch chiếu phim vào CSDL điều khiển chức năng Sửa lịch chiếu phim vào
 * CSDL điều khiển chức năng Xóa lịch Chiếu phim trong CSDL điều khiển chức năng
 * Tìm Kiếm lịch chiếu trong CSDL
 *
 * @author Dang.TH
 * @version 1.0 April 2013
 */
public class CotrollerQLLC {

     public List<Phim> dsphim = null;		      // Danh Sách Phim có trong CSDL
     public List<PhongChieu> dsphongchieu = null;     // Danh Sách Phòng Chiếu Có trong CSDL
     public List<LichChieu> dslichchieu = null;	      // Danh Sách Lịch Chiếu Có trong CSDL
     public ViewDSLichChieu view1 = null;	      // Giao diện QLLC và hiển thị DS Lịch Chiếu  
     public ViewSuaLichChieu view3 = null;	      // Giao diện hiển thị chức năng sửa lịch chiếu
     public ViewThemLichChieu view2 = null;	      // Giao diện hiển thị chức năng thêm lịch chiếu
     public static Connection conn = null;	      // Tạo Kết nối CSDL
     public static Statement stm = null;

     /*
      * Hàm khởi tạo tạo ra một đối tượng điều khiển 
      */
     public CotrollerQLLC() {

	  dsphim = new ArrayList<Phim>();	       //khởi tạo danh sách Phim
	  dsphongchieu = new ArrayList<PhongChieu>();  //khởi tạo danh sách Phòng Chiếu

	  //tạo kết nối Database 
	  try {
	       conn = ConnectionDB.getInstance().getConnection();
	       stm = conn.createStatement();
	  } catch (SQLException ex) {
	       Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
	  }

	  LoadPhim();			     //Load phim từ CSDL lưu vào ArrayList dsPhim
	  LoadPhong();			     //Load Phòng chiếu từ CSDL lưu vào ArrayList dsPhong
	  dslichchieu = LoadLichChieu();     //Load lịch chiếu từ CSDL lưu vào ArrayList dsLichChieu
	  view1 = new ViewDSLichChieu();     //Khởi tạo đối tượng gọi đến giao diện QLLC
	  //Lắng nghe sự kiện trong giao diện QLLC
	  view1.actionPerformed(new HienThiDSLichChieuListenner());
	  //Lắng nghe sự kiện xóa lịch chiếu trong GD QLLC
	  view1.XoaLcActionpeformed(new XoaLichChieuListenner());
	  //Lắng nghe sự kiện tìm kiếm trong GD QLLC
	  view1.TimKiemactionPeformed(new TimKiemLCListenner());
	  view1.setVisible(true);		  //Hiển thị Giao diện QLLC
	  view1.showDSLichChieu(dslichchieu);	  //Hiển thị bảng Danh sách lịch chiếu lên giao diện QLLC
     }

     /*
      * Lắng nghe sự kiện trên giao diện QLLC và hiển thị danh sách lịch chiếu
      */
     class HienThiDSLichChieuListenner implements ActionListener {

	  @Override
	  public void actionPerformed(ActionEvent e) {
	       JButton b = (JButton) e.getSource();
	       //Lắng nghe sự kiện khi bấm nút Thêm Lịch Chiếu trên giao diện QLLC
	       if (b == view1.btnTLC) {
		    //Tạo đối tượng gọi đến lớp giao diện Thêm Lịch Chiếu
		    view2 = new ViewThemLichChieu();
		    view2.setVisible(true); // Hiển thị giao diện Thêm Lịch Chiếu
		    //khởi tạo mã lịch chiếu tự động tăng
		    view2.txtMaLichChieu.setText(String.valueOf(dslichchieu.size() + 1000));
		    view2.ShowDSLichChieu(dslichchieu);	    //Hiển thị danh sách lịch chiếu có trong CSDL
		    view2.ShowDSPhim(dsphim);		    //Hiển thị danh sách Phim có trong CSDL 
		    view2.ShowDSPhong(dsphongchieu);	    //Hiển thị danh sách Phòng Chiếu Có trong CSDL
		    //lắng Nghe sự kiện trong giao diên thêm lịch Chiếu
		    view2.actionPeformed(new AddLichChieuListenner());
		    view1.dispose();	// Đóng giao diện QLLC 
	       }
	       //Lắng nghe sự kiện khi bấm nút Sửa Lịch Chiếu trên giao diện QLLC
	       if (b == view1.btnSLC) {
		    //Tạo đối tượng gọi đến lớp giao diện Sửa Lịch Chiếu
		    view3 = new ViewSuaLichChieu();
		    // Hiển thị giao diện Sửa Lịch Chiếu
		    view3.setVisible(true);
		    view3.ShowDSLichChieu(dslichchieu);	    //Hiển thị danh sách lịch chiếu có trong CSDL
		    view3.ShowDSPhim(dsphim);		    //Hiển thị danh sách Phim có trong CSDL
		    view3.ShowDSPhong(dsphongchieu);	    //Hiển thị danh sách Phòng Chiếu Có trong CSDL
		    //lắng Nghe sự kiện trong giao diên Sửa Lịch Chiếu
		    view3.SuaLichChieuListener(new SuaLichChieuListenner());
		    view1.dispose();	//Đóng giao diện QLLC
	       }
	       //Lắng nghe sự kiện khi bấm nút Trở Về trên giao diện QLLC
	       if (b == view1.btnTV) {
		    view1.mainview = new MainView();   //Tạo đối tượng gọi lớp Hiển thị chính
		    view1.dispose();		       //Đóng giao diện QLLC
		    view1.mainview.setVisible(true);   //Hiển thị giao diện Main View

	       }
	  }
     }
     /*
      *Lớp Lắng nghe sự kiện trên giao diện Thêm Lịch Chiếu
      */

     class AddLichChieuListenner implements ActionListener {

	  @Override
	  public void actionPerformed(ActionEvent ae) {
	       JButton b = (JButton) ae.getSource();
	       //Lắng nghe sự kiện bấm nút Thêm Lịch Chiếu trên giao diện Thêm Lịch Chiếu
	       if (b == view2.btnTLC) {
		    if (view2.txtNgayChieu.getText().equals("") || view2.txtGioChieu.getText().equals("")) {
			 view2.showMessage("Bạn Phải Nhập Đầy Đủ Thông Tin Của Lịch chiếu!");
		    } else {
			 try {
			      LichChieu lc = new LichChieu();
			      lc.setPhim(dsphim.get(view2.lbxPhim.getSelectedIndex()));
			      lc.setPhong(dsphongchieu.get(view2.lbxPhong.getSelectedIndex()));
			      lc.setNgaychieu(view2.txtNgayChieu.getText());
			      lc.setGiocchieu(view2.txtGioChieu.getText());
			      lc.setMalichchieu(dslichchieu.size() + 1000);
			      System.out.println(chkLC(lc));
			      try {
				   ThemLC(lc);
			      } catch (SQLException ex) {
				   Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
			      }
			      //dslichchieu=LoadLichChieu();
			      //view2.showMessage("Them Lich Chieu Thanh Cong!");
			      view2.txtMaLichChieu.setText(String.valueOf(dslichchieu.size() + 1000));
			      view2.ShowDSLichChieu(dslichchieu);
			      view2.txtNgayChieu.setText(null);
			      view2.txtGioChieu.setText(null);
			 } catch (SQLException ex) {
			      Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
			 }
		    }

	       }
	       //Lắng nghe sự kiện bấm nút Trở về trên giao diện Thêm Lịch Chiếu
	       if (b == view2.btnTV) {
		    view1 = new ViewDSLichChieu();
		    view1.actionPerformed(new HienThiDSLichChieuListenner());
		    view1.XoaLcActionpeformed(new XoaLichChieuListenner());
		    view1.TimKiemactionPeformed(new TimKiemLCListenner());
		    view1.setVisible(true);
		    view1.showDSLichChieu(dslichchieu);
		    view2.dispose();

	       }
	  }
     }

     /*
      *Lớp Lắng nghe sự kiện trên giao diện Sửa Lịch Chiếu
      */
     class SuaLichChieuListenner implements ActionListener {

	  @Override
	  public void actionPerformed(ActionEvent ae) {
	       JButton b = (JButton) ae.getSource();
	       //Lắng nghe sự kiện bấm nút Cập Nhật trên giao diện Sửa Lịch Chiếu
	       if (b == view3.btnCapNhat) {
		    if (view3.txtNgayChieu.getText().equals("") || view3.txtGioChieu.getText().equals("")) {
			 view3.showMessage("BẠN PHẢI NHẬP ĐẦY ĐỦ THÔNG TIN LỊCH CHIẾU!");
		    } else {
			 LichChieu l = new LichChieu();
			 l.setMalichchieu(Integer.parseInt(view3.txtMaLichChieu.getText()));
			 l.setPhim(dsphim.get(view3.cboPhim.getSelectedIndex()));
			 l.setPhong(dsphongchieu.get(view3.cboPhong.getSelectedIndex()));
			 l.setNgaychieu(view3.txtNgayChieu.getText());
			 l.setGiocchieu(view3.txtGioChieu.getText());
			 try {
			      SuaLC(l);
			 } catch (SQLException ex) {
			      Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
			 }
			 view3.ShowDSLichChieu(dslichchieu);
		    }
	       }
	       //Lắng nghe sự kiện bấm nút Trở về trên giao diện Sửa Lịch Chiếu
	       if (b == view3.btnTroVe) {
		    view1 = new ViewDSLichChieu();
		    view1.actionPerformed(new HienThiDSLichChieuListenner());
		    view1.XoaLcActionpeformed(new XoaLichChieuListenner());
		    view1.TimKiemactionPeformed(new TimKiemLCListenner());
		    view1.setVisible(true);
		    view1.showDSLichChieu(dslichchieu);
		    view3.dispose();
	       }
	  }
     }

     /*
      *Lớp Lắng nghe sự kiến xóa lịch chiếu trên giao diện QLLC
      */
     class XoaLichChieuListenner implements ActionListener {

	  @Override
	  public void actionPerformed(ActionEvent ae) {
	       JButton b = (JButton) ae.getSource();
	       //Lắng nghe sự kiên bấm nút Xóa Lịch Chiếu trên giao diện QLLC
	       if (b == view1.btnXLC) {
		    if (view1.tblLC.getSelectedRowCount() == 0) {
			 JOptionPane.showMessageDialog(view1, "HÃY CHỌN LỊCH CHIẾU CẦN XÓA TRÊN BẢNG DS LỊCH CHIÊU",
				 null, JOptionPane.INFORMATION_MESSAGE);
		    } else {
			 int row = view1.tblLC.getSelectedRow();
			 int i = JOptionPane.showConfirmDialog(view1, "BẠN CÓ THỰC SỰ MUỐN XÓA LỊCH CHIẾU NÀY KHÔNG?", null, 2);
			 if (i == 0) {
			      XoaLc(Integer.parseInt(view1.tblLC.getValueAt(row, 0).toString()));
			      view1.showDSLichChieu(dslichchieu);
			      JOptionPane.showMessageDialog(view1, "LỊCH CHIẾU ĐÃ ĐƯỢC XÓA THÀNH CÔNG!");
			 }
		    }

	       }

	  }
     }

     /*
      *Lớp Lắng nghe sự kiện Tìm kiếm trên giao diện QLLC
      */
     class TimKiemLCListenner implements ActionListener {

	  @Override
	  public void actionPerformed(ActionEvent ae) {
	       List<LichChieu> List = new ArrayList<LichChieu>();
	       JButton b = (JButton) ae.getSource();
	       //Lắng nghe sự kiện bấm nút Tìm kiếm trên giao diện QLLC 
	       if (b == view1.btnTK1) { //Tìm kiếm them tên phim
		    List = TimKiemLichChieu(1);
		    view1.showDSLichChieu(List);
		    view1.txtTenPhim.setText("");
	       }
	       if (b == view1.btnTK2) {//Tìm kiếm theo ngày chiếu
		    List = TimKiemLichChieu(2);
		    view1.showDSLichChieu(List);
		    view1.txtNgayChieu.setText("");
	       }
	       if (b == view1.btnTK3) {//Tìm kiếm them giờ chiếu
		    List = TimKiemLichChieu(3);
		    view1.showDSLichChieu(List);
		    view1.txtGioChieu.setText("");
	       }
	  }
     }

     /*
      *Hàm Load phim từ CSDL giá trị trả về 
      *	là một danh sách phim được lưu vào ArrayList dsPhim 
      */
     public void LoadPhim() {
	  try {
	       //Truy vấn Cơ Sở Dữ Liệu
	       ResultSet rs = stm.executeQuery("SELECT * FROM [QLBVXP].[dbo].[PHIM]");
	       if (rs != null) {
		    while (rs.next()) {
			 Phim p = new Phim();
			 p.setMaphim(rs.getInt(1));
			 p.setTenphim(rs.getString(2));
			 p.setDienvien(rs.getString(3));
			 p.setDaodien(rs.getString(4));
			 p.setNamsx(rs.getInt(5));
			 p.setThoiluong(rs.getInt(6));
			 p.setTheloai(rs.getString(7));
			 p.setTheloai(rs.getString(8));
			 dsphim.add(p);
		    }
	       } else {
		    System.out.println("Danh Sach Phim Trong!");
	       }

	  } catch (SQLException ex) {
	       Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
	  }

     }

     /*
      *Hàm Load Phòng Chiếu từ CSDL giá trị trả về 
      *	là một danh sách Phòng chiếu được lưu vào ArrayList dsPhong 
      */
     public void LoadPhong() {
	  try {
	       //Truy vấn cơ sở dữ liệu
	       ResultSet rs = stm.executeQuery("SELECT * FROM [QLBVXP].[dbo].[PHONGCHIEU]");
	       if (rs != null) {
		    while (rs.next()) {
			 PhongChieu pc = new PhongChieu();
			 pc.setMaphong(rs.getInt(1));
			 pc.setTenphong(rs.getString(2));
			 pc.setSoluongghe(Integer.parseInt(rs.getString(3)));
			 pc.setTheloai(rs.getString(4));
			 dsphongchieu.add(pc);
		    }
	       } else {
		    System.out.println("Danh Sach Phong Trong!");
	       }

	  } catch (SQLException ex) {
	       Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
	  }
     }

     /*
      *Hàm Load Lịch Chiếu từ CSDL giá trị trả về 
      *	là một danh sách Phòng chiếu được lưu vào ArrayList dsLichChieu
      */
     public List<LichChieu> LoadLichChieu() {
	  List<LichChieu> List = new ArrayList<LichChieu>();
	  try {
	       //Truy vấn Cơ Sở Dữ Liệu
	       ResultSet rs = stm.executeQuery("SELECT * FROM [QLBVXP].[dbo].[LICHCHIEU]");
	       if (rs != null) {
		    while (rs.next()) {
			 LichChieu lc = new LichChieu();
			 lc.setMalichchieu(rs.getInt(1));
			 lc.setPhim(lc.getphim(dsphim, rs.getInt(2)));
			 lc.setPhong(lc.getPhong(dsphongchieu, rs.getInt(3)));
			 lc.setNgaychieu(rs.getString(4));
			 lc.setGiocchieu(rs.getString(5));
			 List.add(lc);
		    }
		    return List;
	       } else {
		    System.out.println("Danh Sach Lich Chieu Trong!");
		    return null;
	       }

	  } catch (SQLException ex) {
	       Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  return null;
     }

     /*
      * Hàm kiểm tra lịch chiếu trước khi thêm,cập nhật vào CSDL
      * có 2 giá trị trả về
      *	  true : nếu lịch chiếu thỏa mãn các yêu cầu đề ra
      *		    và được thêm, cập nhật vào CSDL
      *	  false : nếu lịch chiếu không thỏa mãn các yêu cầu đề ra 
      *		    và sẽ không được thêm vào CSDL
      */
     public boolean chkLC(LichChieu lc) throws SQLException {
	  //Truy vấn CSDL kiểm tra xem lịch chiếu đã tồn tại hay chưa?
	  PreparedStatement ps = conn.prepareStatement("select * from LICHCHIEU "
		  + "where Maphim=? and Maphong=? and Ngaychieu=? and Giochieu=?");
	  ps.setInt(1, lc.getPhim().getMaphim());
	  ps.setInt(2, lc.getPhong().getMaphong());
	  ps.setString(3, lc.getNgaychieu());
	  ps.setString(4, lc.getGiocchieu());
	  ResultSet rs = ps.executeQuery();
	  if (rs.next()) {
	       return true;
	  }
	  return false;
     }
     public boolean ktLC(LichChieu lc) throws SQLException{
	  Calendar cal = Calendar.getInstance();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	  String date = dateFormat.format(cal.getTime());
	  PreparedStatement ps = conn.prepareStatement("select * from LICHCHIEU "
		  + "where Ngaychieu<?");
	  ps.setString(1,date);
	  ResultSet rs = ps.executeQuery();
	  if(rs.next()){
	       return true;
	  }
	  return false;
     }

     /*
      * Hàm Thêm lịch chiếu vào CSDL
      *	  Input : Đối tượng LichChieu lc
      *	  Output : LichChieu lc được thêm vào CSDL
      */
     public void ThemLC(LichChieu lc) throws SQLException {

	  if (chkLC(lc) == false&&ktLC(lc)==false) {//kiểm tra lịch chiếu
	       try {
		    //Truy vấn Cơ sở dữ liệu
		    PreparedStatement ps = conn.prepareStatement("INSERT INTO [QLBVXP].[dbo].[LICHCHIEU]"
			    + "([Malichchieu],[Maphim],[Maphong],[Ngaychieu],[Giochieu])"
			    + "VALUES(?,?,?,?,?)");
		    ps.setInt(1, lc.getMalichchieu());
		    ps.setInt(2, lc.getPhim().getMaphim());
		    ps.setInt(3, lc.getPhong().getMaphong());
		    ps.setString(4, lc.getNgaychieu());
		    ps.setString(5, lc.getGiocchieu());
		    ps.execute();
		    dslichchieu.removeAll(dslichchieu);
		    dslichchieu = LoadLichChieu();
		    view2.showMessage("THÊM LỊCH CHIẾU THÀNH CÔNG!");
	       } catch (SQLException ex) {
		    Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
	       }
	  } else {
	       JOptionPane.showMessageDialog(null, "LỊCH CHIẾU ĐÃ TỒN TẠI");
	  }
     }
     /*
      * Hàm Sửa lịch Chiếu trong CSDL
      *	  Input: Đối tượng LichChieu lc
      *	  Output: LichChieu lc được cập nhật
      */

     public void SuaLC(LichChieu lc) throws SQLException {
	  if (chkLC(lc) == false&&ktLC(lc)==false) {
	       try {
		    // đây là 1 cách khác, nối chuỗi để tạo câu truy vấn. cách này nên hạn chế dùng.
		    stm.execute("UPDATE [QLBVXP].[dbo].[LICHCHIEU]"
			    + "SET [Maphim] =" + lc.getPhim().getMaphim()
			    + ",[Maphong] =" + lc.getPhong().getMaphong()
			    + ",[Ngaychieu] ='" + lc.getNgaychieu()
			    + "',[Giochieu] = '" + lc.getGiocchieu()
			    + "'WHERE [Malichchieu]=" + lc.getMalichchieu() + "");
		    dslichchieu.removeAll(dslichchieu);
		    dslichchieu = LoadLichChieu();
		    view3.showMessage("CẬP NHẬT LỊCH CHIẾU THÀNH CÔNG!");
	       } catch (SQLException ex) {
		    Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
	       }
	  }
     }

     /*
      * Hàm Xóa lịch chiếu trong CSDL
      *	  Input: Đối tượng LichChieu lc
      *	  Ouput: LichChieu lc bị xóa khỏi CSDL
      */
     public void XoaLc(int id) {
	  try {
	       stm.executeUpdate("DELETE FROM [QLBVXP].[dbo].[LICHCHIEU]WHERE Malichchieu=" + id + "");
	       dslichchieu.removeAll(dslichchieu);
	       dslichchieu = LoadLichChieu();
	  } catch (SQLException ex) {
	       Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
	  }
     }

     /*
      * Hàm tìm kiếm lịch chiếu trả về một danh sách lịch chiếu
      *	  thỏa mãn điều kiệ tìm kiếm
      *	Ở đây có 3 điều kiện tìm kiếm:
      *	  1 Tìm kiếm theo Tên Phim
      *	  2 Tìm kiếm theo Ngày Chiếu
      *	  3 Tìm kiếm theo Giờ Chiếu
      * ...........................................................
      */
     public List<LichChieu> TimKiemLichChieu(int type) {
	  List<LichChieu> List = new ArrayList<LichChieu>();
	  switch (type) {
	       case 1://Tìm kiếm theo Tên Phim
		    for (LichChieu lc : dslichchieu) {
			 if (view1.txtTenPhim.getText().equals(lc.getPhim().getTenphim())) {
			      List.add(lc);
			 }
		    }
		    break;
	       case 2://Tìm kiếm theo Ngày Chiếu
		    for (LichChieu lc : dslichchieu) {
			 if (view1.txtNgayChieu.getText().equals(lc.getNgaychieu())) {
			      List.add(lc);
			 }
		    }
		    break;
	       case 3://Tìm kiếm theo Giờ Chiếu
		    ResultSet rs;
		    try {
			 rs = stm.executeQuery("SELECT * FROM LICHCHIEU WHERE Giochieu='"
				 + view1.txtGioChieu.getText() + "'");
			 while (rs.next()) {
			      LichChieu lc = new LichChieu();
			      lc.setMalichchieu(rs.getInt(1));
			      lc.setPhim(lc.getphim(dsphim, rs.getInt(2)));
			      lc.setPhong(lc.getPhong(dsphongchieu, rs.getInt(3)));
			      lc.setNgaychieu(rs.getString(4));
			      lc.setGiocchieu(rs.getString(5));
			      List.add(lc);
			 }
		    } catch (SQLException ex) {
			 Logger.getLogger(CotrollerQLLC.class.getName()).log(Level.SEVERE, null, ex);
		    }
		    break;
	       default:
		    throw new AssertionError();
	  }
	  return List;
     }

}
