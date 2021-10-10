package com.example.sonagph14343_duanmau.Model;

public class SachModel {
    private int SachID;
    private String SachName;
    private String GiaThue;
    private String MaLoai;

    public SachModel() {
    }

    public SachModel(int sachID, String sachName, String giaThue, String maLoai) {
        SachID = sachID;
        SachName = sachName;
        GiaThue = giaThue;
        MaLoai = maLoai;
    }

    public int getSachID() {
        return SachID;
    }

    public void setSachID(int sachID) {
        SachID = sachID;
    }

    public String getSachName() {
        return SachName;
    }

    public void setSachName(String sachName) {
        SachName = sachName;
    }

    public String getGiaThue() {
        return GiaThue;
    }

    public void setGiaThue(String giaThue) {
        GiaThue = giaThue;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String maLoai) {
        MaLoai = maLoai;
    }

    @Override
    public String toString() {
        return "SachModel{" +
                "SachID=" + SachID +
                ", SachName='" + SachName + '\'' +
                ", GiaThue='" + GiaThue + '\'' +
                ", MaLoai='" + MaLoai + '\'' +
                '}';
    }
}

