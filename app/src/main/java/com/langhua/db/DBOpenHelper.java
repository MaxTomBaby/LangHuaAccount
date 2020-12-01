package com.langhua.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    final static String DBNAME = "LH_db.db";
    final static int VERSION = 1;

    public DBOpenHelper(@Nullable Context context) { // 创建数据库
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建用户登陆表
        db.execSQL("create table 'tb_user'(" +
                "'u_id' Int(11) not null," +
                "'u_password' Varchar(18) not null," +
                "'u_name' Varchar(20) not null," +
                "'u_phone' Int(11) not null," +
                "'u_birth' Varchar(12)," +
                "primary key('u_id'))");

        // 创建支出数据表
        db.execSQL("create table'tb_account'(" +
                "'ac_id' Varchar(20) not null," +
                "'ac_type' Varchar(4) not null," +
                "'ac_data' Float(18) not null," +
                "'ac_time' Date not null," +
                "'ac_rmark' Varchar(100)," +
                "primary key('ac_id'))");

        // 创建收入数据表
        db.execSQL("create table'tb_income'(" +
                "'in_id' Varchar(20) not null," +
                "'in_type' Varchar(4) not null," +
                "'in_data' Float(18) not null," +
                "'in_time' Date not null," +
                "'in_rmark' Varchar(100)," +
                "primary key('in_id'))");

        // 插入数据
        db.execSQL("insert into 'tb_user' values ('13312341234', '123456', '阿峰', '13312341234', null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
