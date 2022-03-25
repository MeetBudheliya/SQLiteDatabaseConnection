package com.example.sqlite_database_connection;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBO extends SQLiteOpenHelper {


    public DBO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "StudentDB", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table student(stud_id Integer primary key autoincrement, stud_name text, stud_age Integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists student");
        onCreate(sqLiteDatabase);
    }

    //Add Data in Student Table
    public  void addData(String name, Integer age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content_value = new ContentValues();
        content_value.put("stud_name",name);
        content_value.put("stud_age",age);
        db.insert("student",null,content_value);
        db.close();
    }
    //Delete Record by Student ID
    public void delete_record(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("student","stud_id=?",new String[]{String.valueOf(id)});
        db.close();
    }

    //get Students list
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor curser = db.rawQuery("select * from student",null);
        return  curser;
    }
}
