/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QLBV;

/**
 *
 * @author huyendth92
 */
import Model.LichChieu;
import Model.Phim;
import Model.PhongChieu;
import Model.Ve;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.JOptionPane;

public class ConnectDataBase {

    // Khai bao cac thuoc tinh
    public Connection con; // doi tuong tao ket noi
    ResultSet rs = null; // Bien chua ket qua thuc thi cau lenh
    Statement stm = null;// bien thuc thi cau lenh
    ArrayList<Ve> dsVe = new ArrayList<Ve>();  // khai bao danh sach Ve
    ArrayList<Phim> dsPhim = new ArrayList<>();
    ArrayList<LichChieu> dsLichChieu = new ArrayList<>();

    //====================================================================================================
    /**
     * Ham tra ve ket noi den CSDL
     */
    public Connection returnCon() {
        // Kiem tra xem driver da duoc nap vao chua
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage());
        }
        // Thiet lap ket noi thong qua DriverManager.. 3 tham so ruyen vao url: duong dan den CSDL
        // user, pass
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\TRANHAIDANG\\SQLEXPRESS:1433;databaseName=QLBVXP", "sa", "123456");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage());
        }
        return con;
    }

    //========================================================================================================
    /**
     * Hàm trả về st gắn connection với CSDL  , Cho phép gửi đến databasse câu lệnh
   
     */
    public Statement returnS() {
        try {
            stm = returnCon().createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return stm;
    }

    //================================================================================================
    /**
     * Hàm trả về rs để thực thi câu lệnh SQL 
     * Tham số truyền vào là 1 câu lệnh SQL s
    
     */
    public ResultSet returnRS(String s) {
        stm = returnS();
        try {
            rs = returnS().executeQuery(s);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage());
        }
        return rs;
    }

    /**
     * Hàm Trả Về Ds Phim có trong CSDL
     */
    public ArrayList<Phim> LayDsPhim() {
        String sql = "select* from PHIM";

        try {
            JdbcRowSet jdbc = new JdbcRowSetImpl(returnRS(sql));
            while (jdbc.next()) {
                Phim phim = new Phim(jdbc.getInt(1), jdbc.getString(2), jdbc.getString(3),
                        jdbc.getString(4), jdbc.getInt(5), jdbc.getInt(6), jdbc.getString(7), jdbc.getString(8));
                dsPhim.add(phim);
            }
            jdbc.close();
            con.close();
            rs.close();
            stm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return dsPhim;
    }

    /**
     * Ham lay ra ds Lich Chieu trong CSDL
     */
    public ArrayList<LichChieu> LayDsLichChieu() {
        // Cau lenh SQL
        String sql = "select phim.*, phong.*, lich.* "
                + "from PHIM phim, PHONGCHIEU phong, LICHCHIEU lich "
                + "where lich.Maphim = phim.Maphim "
                + "and lich.Maphong= phong.Maphong";
        try {
            JdbcRowSet jdbc = new JdbcRowSetImpl(returnRS(sql));
            // Xu ly ket qua 
            while (jdbc.next()) {

                //Lấy dữ liệu cho từng dòng! Tạo mới đối tượng Phim, Phòng Chiếu, Lịch Chiếu

                Phim phim = new Phim(jdbc.getInt(1), jdbc.getString(2), jdbc.getString(3),
                        jdbc.getString(4), jdbc.getInt(5), jdbc.getInt(6), jdbc.getString(7), jdbc.getString(8));
                PhongChieu phong = new PhongChieu(jdbc.getInt(9), jdbc.getString(10), jdbc.getInt(11),
                        jdbc.getString(12));
                LichChieu lichChieu = new LichChieu(jdbc.getInt(13), phim, phong,
                        jdbc.getString(16), jdbc.getString(17));

                dsLichChieu.add(lichChieu);
            }
            // Dong cac ket noi
            jdbc.close();
            con.close();
            rs.close();
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage());
        }
        return dsLichChieu;
    }

    /**
     * Ham tra ve danh sach Ve co trong CSDL
     */
    public ArrayList<Ve> LayDsVe() {
        String sql = "select phim.*, phong.*, lich.*, ve.* "
                + "from PHIM phim, PHONGCHIEU phong, LICHCHIEU lich,VE ve "
                + "where ve.Malichchieu= lich.Malichchieu "
                + "and lich.Maphim= phim.Maphim "
                + "and lich.Maphong = phong.Maphong";
        try {
            JdbcRowSet jdbc = new JdbcRowSetImpl(returnRS(sql));
            while (jdbc.next()) {
                Phim phim = new Phim(jdbc.getInt(1), jdbc.getString(2), jdbc.getString(3),
                        jdbc.getString(4), jdbc.getInt(5), jdbc.getInt(6), jdbc.getString(7), jdbc.getString(8));
                PhongChieu phong = new PhongChieu(jdbc.getInt(9), jdbc.getString(10), jdbc.getInt(11),
                        jdbc.getString(12));
                LichChieu lichChieu = new LichChieu(jdbc.getInt(13), phim, phong,
                        jdbc.getString(16), jdbc.getString(17));

                Ve ve = new Ve(jdbc.getInt(18), lichChieu, jdbc.getInt(20), jdbc.getString(21),
                        jdbc.getFloat(22));
                dsVe.add(ve);
            }
            jdbc.close();
            con.close();
            rs.close();
            stm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
        }
        return dsVe;
    }

    /**
     * Thêm vé mới vào CSDL Tham số truyền vào là một đối tượng Vé
     *
     */
    public void ThemVe(Ve ve) {
        String sql = "insert into VE "
                + "values(" + ve.getLichChieu().getMalichchieu() + ","
                + ve.getSoGhe() + ",N'"
                + ve.getLoaiVe() + "',"
                + ve.getDonGia() + ")";

        try {
            int n = returnS().executeUpdate(sql);


        } catch (SQLException e) {
            //  JOptionPane.showMessageDialog(null, "Loi khi them vao CSDL !!!");
            System.out.println("" + e.getMessage());

        }



    }

    /**
     * Sửa thông tin Vé trong CSDL 
     * Tham số truyền vào là một đối tượng vé mới và 1 đối tượng vé cũ 
     * Trả về số lượng hàng được cập nhật
     */
    public int SuaVe(Ve veMoi, Ve veCu) {
        int n = 0;
        String sql = "update VE set"
                + " Malichchieu = '" + veMoi.getLichChieu().getMalichchieu() + "',"
                + " Soghe = '" + veMoi.getSoGhe() + "',"
                + " Dongia = '" + veMoi.getDonGia() + "'"
                + " where Mave ='" + veCu.getMaVe() + "'";
        try {
            n = returnS().executeUpdate(sql);
            if (n >= 1) {
                return n;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi " + e.getMessage());
            System.out.println("" + e.getMessage());
        }
        return 0;
    }

    /**
     * Hàm xóa một Vé khỏi CSDL
     * Tham số truyền vào là maVe
     *  Tra ve số lượng hàng bị thay đổi trong CSDL
     * 
     */
    public int XoaVe(int maVe) {
        String sql = "delete from VE where Mave = " + maVe;
        int n;
        try {
            n = returnS().executeUpdate(sql);
            if (n > 1) {
                return n;
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
