/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.LichChieu;

/**
 *
 * @author huyendth92_ Ngày 7/4/2013
 */
public class Ve {
    // Khai báo các thuộc tính

    private int maVe;
    private LichChieu lichChieu;
    private int soGhe;
    private String loaiVe;
    private float donGia;

    // Các hàm get và set
    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }

    public LichChieu getLichChieu() {
        return lichChieu;
    }

    public void setLichChieu(LichChieu lichChieu) {
        this.lichChieu = lichChieu;
    }

    public int getMaVe() {
        return maVe;
    }

    public void setMaVe(int maVe) {
        this.maVe = maVe;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }

    // Hàm khởi tạo có tham số và không tham số 
    public Ve(int maVe, LichChieu lichChieu, int soGhe, String loaiVe, float donGia) {
        this.maVe = maVe;
        this.lichChieu = lichChieu;
        this.loaiVe = loaiVe;
        this.soGhe = soGhe;
        this.donGia = donGia;
    }

    public Ve() {
    }

    public Ve(LichChieu lichChieu, int soGhe, String loaiVe, float donGia) {

        this.lichChieu = lichChieu;

        this.soGhe = soGhe;
        this.loaiVe = loaiVe;
        this.donGia = donGia;
    }
}
