/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QLP.Business;

import Model.Phim;
import Model.PhongChieu;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.JdbcRowSet;

/**
 *
 * @author Administrator
 */
public class AuthenticationBL {

     ArrayList<Phim> listPhim = new ArrayList<>();
     ArrayList<PhongChieu> listPC = new ArrayList<>();
     DatabaseConnection data;
     Connection con;
     Statement st;

     public AuthenticationBL() {
	  data = new DatabaseConnection();
	  con = data.getConnection();
	  try {
	       st = con.createStatement();
	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
     }

     public boolean loginPhim(String tendangnhap, String matkhau) throws Exception {
	  try {
	       String sql = "SELECT * FROM DANGNHAP WHERE Tendangnhap = ? and Matkhau= ?";
	       //Statement thường dùng để tạo ra các đối tượng 
	       //mục đích chính là để thực thi các câu lệnh SQL tác động lên CSDL
	       //Statement st = con.createStatement();
	       //PreparedStatement thực thi 1 câu truy vấn có truyền tham số
	       PreparedStatement ps = con.prepareStatement(sql);
	       ps.setString(1, tendangnhap); //quy định của tham số truyền vào
	       ps.setString(2, matkhau);
	       ResultSet rs = ps.executeQuery();
	       //next() là phương thức đọc mẩu tin, phương thức này trả về false khi không có mẩu tin nào để đọc
	       if (rs.next()) {
		    return true;
	       } else {
		    return false;
	       }
	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  return false;
     }

     public boolean testPhongchieu(int maphong, String tenphong) throws Exception {
	  try {
	       String sql = "SELECT * FROM PHONGCHIEU WHERE Maphong = ? and Tenphong= ?";
	       PreparedStatement ps = con.prepareStatement(sql);
	       ps.setInt(1, maphong);
	       ps.setString(2, tenphong);
	       ResultSet rs = ps.executeQuery();
	       if (rs.next()) {
		    return true;
	       } else {
		    return false;
	       }
	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  return false;
     }

     //khoi tao phuong thuc mang? chua danh sach phim
     public ArrayList<Phim> dsPhim() {
	  try {
	       String sql = "SELECT * FROM PHIM";
	       ResultSet rs = st.executeQuery(sql);
	       JdbcRowSet jdbcrs = new JdbcRowSetImpl(rs);

	       while (jdbcrs.next()) {
		    Phim p = new Phim(jdbcrs.getInt(1), jdbcrs.getString(2), jdbcrs.getString(3),
			    jdbcrs.getString(4), jdbcrs.getInt(5), jdbcrs.getInt(6),
			    jdbcrs.getString(7), jdbcrs.getString(8));
		    listPhim.add(p);
	       }
	       jdbcrs.close();
	       rs.close();
	       st.close();
	       con.close();
	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  //phải trả về kiểu listPhim nếu không sẽ báo lỗi NullPointerException chưa có đối tượng NullPointerException
	  return listPhim;
     }

     //khoi tao phuong thuc them phim voi tham so truyen vao
     public void themPhim(Phim ph) {
	  try {
	       data = new DatabaseConnection();
	       con = data.getConnection();
	       String sql = "INSERT INTO PHIM Values(?,?,?,?,?,?,?,?)";
	       if (con == null) {
		    System.out.println("Error");
	       } else {
		    System.out.println("Connection Perfect run....");
		    PreparedStatement ps = con.prepareStatement(sql);
		    ps.setInt(1, ph.getMaphim());
		    ps.setString(2, ph.getTenphim());
		    ps.setString(3, ph.getDienvien());
		    ps.setString(4, ph.getDaodien());
		    ps.setInt(5, ph.getNamsx());
		    ps.setInt(6, ph.getThoiluong());
		    ps.setString(7, ph.getTheloai());
		    ps.setString(8, ph.getGioithieu());
		    ps.executeUpdate();
	       }

	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
     }

     //khoi tao phuong thuc kieu int
     public int suaPhim(Phim newfilm, Phim oldfilm) {
	  try {
	       int n = 0;
	       String update = " UPDATE PHIM SET"
		       + " Tenphim = '" + newfilm.getTenphim() + "',"
		       + " Dienvien = '" + newfilm.getDienvien() + "',"
		       + " Daodien = '" + newfilm.getDaodien() + "',"
		       + " Namsx = '" + newfilm.getNamsx() + "',"
		       + " Thoiluong = '" + newfilm.getThoiluong() + "',"
		       + " Theloaiphim = '" + newfilm.getTheloai() + "',"
		       + " Gioithieu = '" + newfilm.getGioithieu() + "'"
		       + " WHERE Maphim ='" + oldfilm.getMaphim() + "'";
	       data = new DatabaseConnection();
	       con = data.getConnection();
	       st = con.createStatement();
	       n = st.executeUpdate(update);
	       if (n >= 1) {
		    return n;
	       }

	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  return 0;
     }

     //khoi tao phuong thuc  xoa phim
     public int xoaPhim(int maP) {
	  String sql = "delete from PHIM where Maphim = " + maP;
	  int n;
	  try {
	       st = con.createStatement();
	       n = st.executeUpdate(sql);
	       if (n > 1) {
		    return n;
	       }
	  } catch (Exception e) {
	  }
	  return 0;
     }

     public ArrayList<PhongChieu> dsPhongChieu() {
	  try {
	       String sql = "SELECT * FROM PHONGCHIEU";
	       ResultSet rs = st.executeQuery(sql);
	       JdbcRowSet jdbcrs = new JdbcRowSetImpl(rs);

	       while (jdbcrs.next()) {
		    PhongChieu pc = new PhongChieu(jdbcrs.getInt(1), jdbcrs.getString(2), jdbcrs.getInt(3), jdbcrs.getString(4));
		    listPC.add(pc);
	       }
	       jdbcrs.close();
	       rs.close();
	       st.close();
	       con.close();
	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  //phải trả về kiểu listPC nếu không sẽ báo lỗi NullPointerException chưa có đối tượng NullPointerException
	  return listPC;

     }

     public void themPC(PhongChieu pc) {
	  data = new DatabaseConnection();
	  con = data.getConnection();
	  String sql = "INSERT INTO PHONGCHIEU Values(?,?,?,?)";
	  if (con == null) {
	       System.out.println("Error");
	  } else {
	       try {
		    System.out.println("Connection Perfect run....");
		    PreparedStatement ps = con.prepareStatement(sql);
		    ps.setInt(1, pc.getMaphong());
		    ps.setString(2, pc.getTenphong());
		    ps.setInt(3, pc.getSoluongghe());
		    ps.setString(4, pc.getTheloai());
		    ps.executeUpdate();
	       } catch (SQLException ex) {
		    Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	       }
	  }
     }

     public int suaPC(PhongChieu newpc, PhongChieu oldpc) {
	  try {
	       int m = 0;

	       String update = " UPDATE PHONGCHIEU SET"
		       + " Tenphong = '" + newpc.getTenphong() + "',"
		       + " Soluongghe = '" + newpc.getSoluongghe() + "',"
		       + " Theloaiphong = '" + newpc.getTheloai() + "'"
		       + " WHERE Maphong ='" + oldpc.getMaphong() + "'";
	       data = new DatabaseConnection();
	       con = data.getConnection();
	       st = con.createStatement();
	       m = st.executeUpdate(update);
	       if (m >= 1) {
		    return m;
	       }
	  } catch (SQLException ex) {
	       Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
	  }
	  return 0;
     }

     public int xoaPhongchieu(int maPC) {
	  String sql = "delete from PHONGCHIEU where Maphong = " + maPC;
	  int n;
	  try {
	       st = con.createStatement();
	       n = st.executeUpdate(sql);
	       if (n > 1) {
		    return n;
	       }
	  } catch (Exception e) {
	  }
	  return 0;
     }
}
