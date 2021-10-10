package com.example.sonagph14343_duanmau.Model;

public class PhieuMuonModel {
    private int maPM;
    private String maTT;
    private int maTV;
    private String maSach;
    private String tienThue;
    private int ngay;
    private int traSach;

    public PhieuMuonModel() {
    }

    public PhieuMuonModel(int maPM, String maTT, int maTV, String maSach, String tienThue, int ngay, int traSach) {
        this.maPM = maPM;
        this.maTT = maTT;
        this.maTV = maTV;
        this.maSach = maSach;
        this.tienThue = tienThue;
        this.ngay = ngay;
        this.traSach = traSach;
    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTienThue() {
        return tienThue;
    }

    public void setTienThue(String tienThue) {
        this.tienThue = tienThue;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getTraSach() {
        return traSach;
    }

    public void setTraSach(int traSach) {
        this.traSach = traSach;
    }

    @Override
    public String toString() {
        return "PhieuMuonModel{" +
                "maPM=" + maPM +
                ", maTT='" + maTT + '\'' +
                ", maTV=" + maTV +
                ", maSach='" + maSach + '\'' +
                ", tienThue='" + tienThue + '\'' +
                ", ngay=" + ngay +
                ", traSach=" + traSach +
                '}';
    }
}
