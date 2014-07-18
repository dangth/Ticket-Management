/**
 * Projectname Quản Lý Bán Vé Xem Phim
 * Package Model
 * ClassName LichChieu
 * @author RubikCrew
 * @Version 1.0 April 2013
 * 
 */
package Model;

import java.util.List;

/*  Lớp Định Nghĩa Thực Thể Lịch Chiếu
 *  Bao gồm các thuộc tính:
 *   Mã Lịch Chiếu  malichchieu	   int
 *   Phim Chiếu	    phim	   Phim	
 *   Phòng Chiếu    phong	   Phong
 *   Ngày Chiếu	    ngaychieu	   String
 * @author Dang.TH
 * @Version 1.0 April 2013
 */
public class LichChieu {
    private int malichchieu;		// Mã Lịch Chiếu
    private Phim phim=null;		// Phim Chiếu
    private PhongChieu phong=null;	// Phòng Chiếu
    private String ngaychieu=null;	// Ngày Chiếu
    private String giocchieu=null;	// Giờ Chiếu
    
    /*Hàm khởi tạo không tham So trả về một đối tượng LichChieu*/
    public LichChieu() {
    }
    
    /*Hàm khởi Tạo Có Tham Số trả về một đối tượng LịchChieu*/
    public LichChieu(int malichchieu, Phim phim, PhongChieu phong, String ngaychieu, String giocchieu) {
        this.malichchieu = malichchieu;	
        this.phim = phim;
        this.phong = phong;
        this.ngaychieu = ngaychieu;
        this.giocchieu = giocchieu;
    }
    
    /*
     * Các hàm nhập xuất dữ liệu
     */
    
    //Hàm Lấy Giờ Chiếu trả về giá trị của Giờ Chiếu
    public String getGiocchieu() {
        return giocchieu;
    }
    //Hàm Nhập Giờ Chiếu truyền giá trị cho giochieu
    public void setGiocchieu(String giocchieu) {
        this.giocchieu = giocchieu;
    }
    //Hàm Lấy Mã lịch Chiếu trả về giá trị của Mã lịch Chiếu
    public int getMalichchieu() {
        return malichchieu;
    }
    //Hàm Nhập Mã lịch chiếu truyền giá trị cho malichchieu
    public void setMalichchieu(int malichchieu) {
        this.malichchieu = malichchieu;
    }
    //Hàm Lấy Ngày Chiếu trả về giá trị của ngày chiếu
    public String getNgaychieu() {
        return ngaychieu;
    }
    //Hàm Nhập Ngày Chiếu truyền giá trị cho ngaychieu
    public void setNgaychieu(String ngaychieu) {
        this.ngaychieu = ngaychieu;
    }
    //Hàm Lấy Phim Trả về một đối tượng Phim
    public Phim getPhim() {
        return phim;
    }
    //Hàm Lấy Phim Từ Danh Sách Phim trả về một đối tượng Phim
    public Phim getphim(List<Phim> ListPhim, int id){
        for (Phim phim : ListPhim) {
            if(phim.getMaphim()==id){
                return phim;
            }
        }
        return null;
        
    }
    //Hàm Nhập Phim truyền giá trị cho phim
    public void setPhim(Phim phim) {
        this.phim = phim;
    }
    //Hàm Lấy Phòng Chiếu trả về một đối tượng Phòng Chiếu
    public PhongChieu getPhong() {
        return phong;
    }
    /*Hàm Lấy Phòng Chiếu Từ Danh Sách Phòng Chiếu 
     *trả về một đối tượng Phòng Chiếu
     */ 
    public PhongChieu getPhong(List<PhongChieu> LisPhong, int id){
        for (PhongChieu phongChieu : LisPhong) {
            if(phongChieu.getMaphong()==id){
                return phongChieu;
            }
        }
        return null;
        
    }
    //Hàm nhập Phòng Chiếu truyền giá trị cho phong
    public void setPhong(PhongChieu phong) {
        this.phong = phong;
    }
    
    
}
