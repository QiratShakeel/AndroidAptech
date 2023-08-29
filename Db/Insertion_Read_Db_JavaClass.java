package com.example.database_work2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class my_db extends SQLiteOpenHelper {
    static final String db_name= "My_Db";
    static final String tab1= "tbl_roles";
    static final String tab1_col1= "role_Id";
    static final String tab1_col2 = "role_name";
    public my_db(@Nullable Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table "+tab1+"("+tab1_col1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+tab1_col2+" text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table "+tab1);
        onCreate(db);
    }
    public boolean InsertRoles(String name){
        ContentValues cv= new ContentValues();
        cv.put(tab1_col2,name);
        SQLiteDatabase db= getWritableDatabase();
        long res = db.insert(tab1,null,cv);
        if (res==-1)
            return false;
        else
            return true;
    }
    public Cursor GetAllData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor res =db.rawQuery("Select * from "+tab1,null);
        return res;
    }
}
