package com.example.sonagph14343_duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.LoaiSachModel;

import java.util.ArrayList;
import java.util.List;

public class LoaiSachDAO {
    private DatabaseHelper databaseHelper;

    public LoaiSachDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }
    public long InsertLoaiSach(LoaiSachModel loaiSachModel){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenLoai", loaiSachModel.getTenLoai());
        return sqLiteDatabase.insert("LoaiSach",null,contentValues);
    }
    public int DeleteLoaiSach(String id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        return sqLiteDatabase.delete("LoaiSach", "maLoai=?",new String[]{id});
    }
    public int UpdateLoaiSach(LoaiSachModel loaiSachModel){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenLoai", loaiSachModel.getTenLoai());
        return sqLiteDatabase.update("LoaiSach",contentValues,"maLoai=?",new String[]{String.valueOf(loaiSachModel.getMaLoai())});
    }
    public List<LoaiSachModel> GetAllLoaiSach(){
        List<LoaiSachModel> loaiSachModelList = new ArrayList<>();
        String query = "SELECT * FROM LoaiSach";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        sqLiteDatabase.rawQuery(query,null);
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String maLoai = cursor.getString(cursor.getColumnIndex("maLoai"));
                String tenLoai = cursor.getString(cursor.getColumnIndex("tenLoai"));
                LoaiSachModel loaiSachModel = new LoaiSachModel(Integer.parseInt(maLoai),tenLoai);
                loaiSachModelList.add(loaiSachModel);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return loaiSachModelList;
    }
}
