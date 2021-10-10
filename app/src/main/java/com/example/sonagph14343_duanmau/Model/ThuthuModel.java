package com.example.sonagph14343_duanmau.Model;

public class ThuthuModel {
    private String maThuThu;
    private String hoTenTT;
    private String TaiKhoanTT;
    private String matKhauTT;

    public ThuthuModel() {
    }

    public ThuthuModel(String maThuThu, String hoTenTT, String taiKhoanTT, String matKhauTT) {
        this.maThuThu = maThuThu;
        this.hoTenTT = hoTenTT;
        TaiKhoanTT = taiKhoanTT;
        this.matKhauTT = matKhauTT;
    }

    public String getMaThuThu() {
        return maThuThu;
    }

    public void setMaThuThu(String maThuThu) {
        this.maThuThu = maThuThu;
    }

    public String getHoTenTT() {
        return hoTenTT;
    }

    public void setHoTenTT(String hoTenTT) {
        this.hoTenTT = hoTenTT;
    }

    public String getTaiKhoanTT() {
        return TaiKhoanTT;
    }

    public void setTaiKhoanTT(String taiKhoanTT) {
        TaiKhoanTT = taiKhoanTT;
    }

    public String getMatKhauTT() {
        return matKhauTT;
    }

    public void setMatKhauTT(String matKhauTT) {
        this.matKhauTT = matKhauTT;
    }

    @Override
    public String toString() {
        return "ThuthuModel{" +
                "maThuThu='" + maThuThu + '\'' +
                ", hoTenTT='" + hoTenTT + '\'' +
                ", TaiKhoanTT='" + TaiKhoanTT + '\'' +
                ", matKhauTT='" + matKhauTT + '\'' +
                '}';
    }
}
