package com.example.sonagph14343_duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.SachModel;

import java.util.ArrayList;
import java.util.List;

public class SachDAO {
    private DatabaseHelper databaseHelper;

    public SachDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);

    }
    public long InsertSach(SachModel sachModel) {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        contentValues.put("TenSach", sachModel.getSachName());
        contentValues.put("giaThue", sachModel.getGiaThue());
        contentValues.put("maLoai", sachModel.getMaLoai());
        return sqLiteDatabase.insert("Sach", null, contentValues);
    }
    public int UpdateSach(SachModel sachModel){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TenSach", sachModel.getSachName());
        contentValues.put("giaThue",sachModel.getGiaThue());
        return sqLiteDatabase.update("Sach",contentValues,"maSach=?",new String[]{String.valueOf(sachModel.getSachID())});
    }
    public int DeleteSach(String id){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        return sqLiteDatabase.delete("Sach","maSach=?",new String[]{id});
    }
    public List<SachModel> getAllsach(){
        List<SachModel> sachModels = new ArrayList<>();

        String sach = "SELECT * FROM Sach";
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sach,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String maSach = cursor.getString(cursor.getColumnIndex("maSach"));
                String TenSach = cursor.getString(cursor.getColumnIndex("TenSach"));
                String giaThue = cursor.getString(cursor.getColumnIndex("giaThue"));
                String maLoai = cursor.getString(cursor.getColumnIndex("maLoai"));
                SachModel sachModel = new SachModel(Integer.parseInt(maSach),TenSach,giaThue,maLoai);
                sachModels.add(sachModel);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachModels;
    }
}
