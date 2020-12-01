package com.langhua.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.langhua.db.DBOpenHelper;
import com.langhua.model.UserInfo;

public class UserDao {
    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    public UserDao(Context context){
        dbOpenHelper=new DBOpenHelper(context);
    }

    //用户登录
    public boolean login(String username,String userpassword){
        db=dbOpenHelper.getReadableDatabase();//c初始化
        Cursor cursor = db.rawQuery("select * from tb_user where u_id='" + username + "' and u_password='" + userpassword + "'", null);
        if (cursor.moveToNext()){
            cursor.close();
            db.close();
            return  true;
        }
        cursor.close();
        db.close();
        return  false;
    }

    public UserInfo findUserById(String username){
        db=dbOpenHelper.getReadableDatabase();//初始化SQLiteDatabase
        Cursor cursor = db.rawQuery("select * from tb_user where u_id='" + username + "'", null);
        if (cursor.moveToNext()){
            UserInfo userInfo = new UserInfo();
            userInfo.setU_id(cursor.getInt(cursor.getColumnIndex("u_id")));
            userInfo.setU_password(cursor.getString(cursor.getColumnIndex("u_password")));
            userInfo.setU_name(cursor.getString(cursor.getColumnIndex("u_name")));
            userInfo.setU_phone(cursor.getInt(cursor.getColumnIndex("u_phone")));
            userInfo.setU_birth(cursor.getString(cursor.getColumnIndex("u_birth")));
            return userInfo;
        }
        return null;
    }

}
