/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author CEOTRANDANG
 */
public class PhongChieu{
    private int maphong;
    private String tenphong;
    private int soluongghe;
    private String theloai;

    public PhongChieu() {
    }

    public PhongChieu(int maphong, String tenphong, int soluongghe, String theloai) {
        this.maphong = maphong;
        this.tenphong = tenphong;
        this.soluongghe = soluongghe;
        this.theloai = theloai;
    }

    public int getMaphong() {
        return maphong;
    }

    public void setMaphong(int maphong) {
        this.maphong = maphong;
    }

    public int getSoluongghe() {
        return soluongghe;
    }

    public void setSoluongghe(int soluongghe) {
        this.soluongghe = soluongghe;
    }

    public String getTenphong() {
        return tenphong;
    }

    public void setTenphong(String tenphong) {
        this.tenphong = tenphong;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }
    public Object[] toArray(){
        return new Object[]{maphong, tenphong, soluongghe, theloai};
    }
}
