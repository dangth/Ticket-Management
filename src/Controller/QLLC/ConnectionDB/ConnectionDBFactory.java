/**
 * Projectname Quản Lý Bán Vé Xem Phim
 * Package Controller.QLLC
 * ClassName ControllerBD
 * @author RubikCrew
 * @Version 1.0 April 2013
 */
package Controller.QLLC.ConnectionDB;

import Model.LichChieu;
import Model.Phim;
import Model.PhongChieu;
import Model.Ve;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *Lớp Điều khiển kết nối CSDL
 * @author DANG.TH
 * @version 1.0 April 2013
 */
public interface ConnectionDBFactory {
    Connection conn = ConnectionDB.getInstance().getConnection();
    public static final String SELECTALLPHIM="SELECT * FROM dbo.PHIM";
    public static final String SELECTALLPHONG="SELECT * FROM dbo.PHONG";
    public static final String SELECALLLICHCHIEU="SELECT * FROM Ldbo.ICHCHIEU";
    public List<LichChieu> SellecAllLC();
    public List<Phim> SellecAllPhim();
    public List<PhongChieu> SellecAllPC();
    public void Insert(LichChieu lc);
    public void Insert(Phim phim);
    public void Insert(PhongChieu pc);
    public void Insert(Ve ve);
    public void Update(LichChieu lc);
    public void Update(Phim phim);
    public void Update(PhongChieu pc);
    public void Update(Ve ve);
    public void Delete(LichChieu lc);
    public void Delete(Phim phim);
    public void Delete(PhongChieu pc);
    public void Delete(Ve ve);
    public List<LichChieu> FindAllLC(LichChieu lc);
    public List<Phim> FindAllPh(Phim p);
    public List<PhongChieu> FindAllPC(PhongChieu pc);
    public List<Ve> FindAllTK(Ve ve);
    
}
