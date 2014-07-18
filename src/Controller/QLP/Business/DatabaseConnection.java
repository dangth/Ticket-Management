/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.QLP.Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DatabaseConnection {
    Connection con;
    public Connection getConnection(){
        try {       
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost\\TRANHAIDANG\\SQLEXPRESS:1433;databaseName=QLBVXP", "sa", "123456");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    public void Close(){
        if (con!=null) 
            try {
            if (!con.isClosed())
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AuthenticationBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
