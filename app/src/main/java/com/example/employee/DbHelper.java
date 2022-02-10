package com.example.employee;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    String dbname = "employee.db";
    String tablename = "employee";
    String col1 = "id";
    String col2 = "employee";
    String col3 = "name";
    String col4 = "designation";
    String col5 = "phonenumber";


    public DbHelper(Context context) {
        super(context,"employee.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table" + tablename + "(" + col1 +
                "integer primary key autoincrement, " + col2 + " text," +
                " " + col3 + " text, " + col4 + " text, " + col5 + " text)";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        String query = "drop table if exists " + tablename;
        db.execSQL(query);
        onCreate(db);


    }

    public boolean insertemployee(String employee, String name, String designation, String phonenumber)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(col2, employee);
        content.put(col3, name);
        content.put(col4, designation);
        content.put(col5, phonenumber);
        long status = db.insert(tablename, null, content);
        if (status == -1) {
            return false;

        } else {
            return true;
        }

    }
}




