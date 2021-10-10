package com.example.sonagph14343_duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.ThuthuModel;

public class ThuThuDAO {
    private DatabaseHelper databaseHelper;
    public ThuThuDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }
    public long InsertThuThu(ThuthuModel thuthuModel){
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hoTenTT", thuthuModel.getHoTenTT());
        contentValues.put("TaiKhoanTT", thuthuModel.getTaiKhoanTT());
        contentValues.put("matKhau", thuthuModel.getMatKhauTT());
        long reult = sqLiteDatabase.insert("ThuThu",null,contentValues);
        return reult;
    }
}
