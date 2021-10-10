package com.example.sonagph14343_duanmau.Model;

public class ThanhVienModel {
    private int maThanhVien;
    private String tenThanhVien;
    private String namSinh;

    public ThanhVienModel() {
    }

    public ThanhVienModel(int maThanhVien, String tenThanhVien, String namSinh) {
        this.maThanhVien = maThanhVien;
        this.tenThanhVien = tenThanhVien;
        this.namSinh = namSinh;
    }

    public int getMaThanhVien() {
        return maThanhVien;
    }

    public void setMaThanhVien(int maThanhVien) {
        this.maThanhVien = maThanhVien;
    }

    public String getTenThanhVien() {
        return tenThanhVien;
    }

    public void setTenThanhVien(String tenThanhVien) {
        this.tenThanhVien = tenThanhVien;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return "ThanhVienModel{" +
                "maThanhVien=" + maThanhVien +
                ", tenThanhVien='" + tenThanhVien + '\'' +
                ", namSinh='" + namSinh + '\'' +
                '}';
    }
}
