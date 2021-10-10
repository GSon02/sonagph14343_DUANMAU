package com.example.sonagph14343_duanmau.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.sonagph14343_duanmau.Model.SachModel;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    public Context context;
    private DatabaseHelper databaseHelper;


    public DatabaseHelper(@Nullable Context context) {
        super(context, "DatabaseQLS.db", null, 3);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableThuThu="create table ThuThu(" +
                "maTT INTEGER PRIMARY KEY AUTOINCREMENT," +
                "hoTenTT TEXT NOT NULL," +
                "TaiKhoanTT TEXT NOT NULL," +
                "matKhau TEXT NOT NULL)";
        sqLiteDatabase.execSQL(createTableThuThu);
        sqLiteDatabase.execSQL("INSERT INTO ThuThu VALUES(null,\"Test\",\"admin\",\"admin\")");

        String createTableThanhVien="create table ThanhVien(" +
                "maTV INTEGER  PRIMARY KEY AUTOINCREMENT," +
                "hoTen TEXT NOT NULL," +
                "namSinh TEXT NOT NULL)";
        sqLiteDatabase.execSQL(createTableThanhVien);
        sqLiteDatabase.execSQL("INSERT INTO ThanhVien VALUES(null, \"Gson\",\"2002\")");
        sqLiteDatabase.execSQL("INSERT INTO ThanhVien VALUES(null, \"Gson\",\"2002\")");

        String createTableLoaiSach=
                "create table LoaiSach(" +
                        "maLoai INTEGER  PRIMARY KEY AUTOINCREMENT," +
                        "tenLoai TEXT NOT NULL)";
        sqLiteDatabase.execSQL(createTableLoaiSach);
        sqLiteDatabase.execSQL("INSERT INTO LoaiSach VALUES(null, \"KINH TE\")");
        sqLiteDatabase.execSQL("INSERT INTO LoaiSach VALUES(null, \"NGOAI NGU\")");

        String createTableSach="create table Sach(" +
                "maSach INTEGER  PRIMARY KEY AUTOINCREMENT," +
                "TenSach TEXT NOT NULL," +
                "giaThue TEXT NOT NULL," +
                "maLoai INTEGER REFERENCES LoaiSach(maLoai))";
        sqLiteDatabase.execSQL(createTableSach);

        String createTablePhieuMuon="create table PhieuMuon(" +
                "maPM INTEGER  PRIMARY KEY AUTOINCREMENT," +
                "maTT TEXT REFERENCES ThuThu(maTT)," +
                "maTV INTEGER REFERENCES ThanhVien(maTV)," +
                "maSach INTERGER REFERENCES Sach(maSach)," +
                "tienThue INTERGER NOT NULL," +
                "ngay DATE NOT NULL," +
                "traSach INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(createTablePhieuMuon);
    }

        @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            String dropTableLoaiThuThu = "drop table if exists ThuThu";
            sqLiteDatabase.execSQL(dropTableLoaiThuThu);
            String dropTableThanhVien= "drop table if exists ThanhVien";
            sqLiteDatabase.execSQL(dropTableThanhVien);
            String dropTableLoaiSach = "drop table if exists LoaiSach";
            sqLiteDatabase.execSQL(dropTableLoaiSach);
            String dropTableSach = "drop table if exists Sach";
            sqLiteDatabase.execSQL(dropTableSach);
            String dropTablePhieuMuon = "drop table if exists PhieuMuon";
            sqLiteDatabase.execSQL(dropTablePhieuMuon);
    }
    public Boolean checkUserName(String user){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ThuThu WHERE TaiKhoanTT=?",new String[]{user});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
    public Boolean checkUserNamePass(String user , String pass){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ThuThu WHERE TaiKhoanTT=? AND matKhau=?",new String[]{user, pass});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
