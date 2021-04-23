package com.desertLocust.locusthunter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public  static final  String DB_NAME = "Users.db";

    public DbHelper(@Nullable Context context){
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(username TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists user");
    }
    public boolean insertData(String usrname, String psward){
    SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", usrname);
        contentValues.put("password", psward);
        long result  = db.insert("users", null, contentValues);

        if (result == -1){
            return false;

        }else
            return true;
    }

    public  boolean checkUsername(String uName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ?", new String[]{uName});
        if (cursor.getCount() > 0){
            return  true;
        }
        else return false;
    }
    public  boolean checkPasswordName(String Uname, String Pword){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor1 = db.rawQuery("select * from users where username = ? and password = ?", new String[]{Uname,Pword});
        if (cursor1.getCount()> 0){
            return  true;
        }else  return false;
    }
}
