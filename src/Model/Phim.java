/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author CEOTRANDANG
 */
public class Phim{
    private int maphim;
    private String tenphim;
    private String dienvien;
    private String daodien;
    private int namsx;
    private int thoiluong;
    private String theloai;
    private String gioithieu;

    public Phim() {
    }

    public Phim(int maphim, String tenphim, String dienvien, String daodien, int namsx, int thoiluong, String theloai, String gioithieu) {
        this.maphim = maphim;
        this.tenphim = tenphim;
        this.dienvien = dienvien;
        this.daodien = daodien;
        this.namsx = namsx;
        this.thoiluong = thoiluong;
        this.theloai = theloai;
        this.gioithieu = gioithieu;
    }

    public String getDaodien() {
        return daodien;
    }

    public void setDaodien(String daodien) {
        this.daodien = daodien;
    }

    public String getDienvien() {
        return dienvien;
    }

    public void setDienvien(String dienvien) {
        this.dienvien = dienvien;
    }

    public String getGioithieu() {
        return gioithieu;
    }

    public void setGioithieu(String gioithieu) {
        this.gioithieu = gioithieu;
    }

    public int getMaphim() {
        return maphim;
    }

    public void setMaphim(int maphim) {
        this.maphim = maphim;
    }

    public int getNamsx() {
        return namsx;
    }

    public void setNamsx(int namsx) {
        this.namsx = namsx;
    }

    public String getTenphim() {
        return tenphim;
    }

    public void setTenphim(String tenphim) {
        this.tenphim = tenphim;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public int getThoiluong() {
        return thoiluong;
    }

    public void setThoiluong(int thoiluong) {
        this.thoiluong = thoiluong;
    }
    public Object[] toArray(){
        return new Object[]{maphim, tenphim, dienvien, daodien, namsx, thoiluong, theloai, gioithieu};
    }
    
}
