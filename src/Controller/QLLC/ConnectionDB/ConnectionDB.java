/**
 * Projectname Quản Lý Bán Vé Xem Phim
 * Package Controller.QLLC
 * ClassName ControllerBD
 * @author RubikCrew
 * @Version 1.0 April 2013
 */

package Controller.QLLC.ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Lớp điều khiển kết nối hệ quản trị csdl Microsoft SQL Server 2008
 * @author DANG.TH
 * @version 1.0 April 2013
 */
public class ConnectionDB {

    private static volatile ConnectionDB Connect = null;
    private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DBHost = "jdbc:sqlserver://localhost\\TRANHAIDANG\\SQLEXPRESS";
    private static final String DBPort = "1433";
    private static final String DBName = "QLBVXP";
    private static final String DBUser = "sa";
    private static final String DBPass = "123456";
    private Connection conn;
    
    /*Hàm khởi tạo một đối tượng kết nối*/
    private ConnectionDB() {
        super();
         try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(DBHost + ":" + DBPort + ";databaseName=" + DBName, DBUser, DBPass);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*Singleton Connection Tạo một kết nối CSDL duy nhất*/
    public static ConnectionDB getInstance() {
        if (Connect == null) {
            synchronized (ConnectionDB.class) {
                if (Connect == null) {
                    Connect = new ConnectionDB();
                }
            }
        }    
        return Connect;
    }
    /*Hàm lấy Connection trả về một luồng kết nối CSDL*/
    public Connection getConnection() {
       
        return conn;
    }
    /*Hàm ngắt kết nối CSDL*/
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
