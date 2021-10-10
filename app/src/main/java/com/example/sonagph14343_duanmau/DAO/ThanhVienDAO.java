package com.example.sonagph14343_duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.SachModel;
import com.example.sonagph14343_duanmau.Model.ThanhVienModel;

import java.util.ArrayList;
import java.util.List;

public class ThanhVienDAO {
    private DatabaseHelper databaseHelper;
    public ThanhVienDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }
    public long InsertThanhVien(ThanhVienModel thanhVienModel){
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        contentValues.put("hoTen",thanhVienModel.getTenThanhVien());
        contentValues.put("namSinh",thanhVienModel.getNamSinh());
        return sqLiteDatabase.insert("ThanhVien", null, contentValues);
    }
    public int UpdateTV(ThanhVienModel thanhVienModel){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoTen", thanhVienModel.getTenThanhVien());
        contentValues.put("namSinh",thanhVienModel.getNamSinh());
        return sqLiteDatabase.update("ThanhVien",contentValues,"maTV=?",new String[]{String.valueOf(thanhVienModel.getMaThanhVien())});
    }
    public List<ThanhVienModel> getAllThanhVien(){
        List<ThanhVienModel> thanhVienModelList = new ArrayList<>();
        String thanhvien = "SELECT * FROM ThanhVien";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(thanhvien,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String maTV = cursor.getString(cursor.getColumnIndex("maTV"));
                String hoTen = cursor.getString(cursor.getColumnIndex("hoTen"));
                String namSinh = cursor.getString(cursor.getColumnIndex("namSinh"));
                ThanhVienModel thanhVienModel = new ThanhVienModel(Integer.parseInt(maTV),hoTen,namSinh);
                thanhVienModelList.add(thanhVienModel);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return thanhVienModelList;
    }
    public int DeleteThanhVien(String id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        return sqLiteDatabase.delete("ThanhVien", "maTV=?", new String[]{id});
    }
}
