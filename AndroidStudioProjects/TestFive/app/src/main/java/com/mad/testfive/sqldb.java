package com.mad.testfive;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

public class sqldb extends SQLiteOpenHelper {

    final static String DB="User",TABLE="users";

    public sqldb(MainActivity mainActivity){
        super(mainActivity,DB,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE+"(username TEXT, password TEXT)";
        db.execSQL(query);
    }

    public boolean addUser(String username, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("password",password);
        if(db.insert(TABLE,null,cv)==-1){
            return false;
        }else{
            return true;
        }
    }

    public boolean getData(String username, String password){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cr = db.rawQuery("Select * from "+TABLE+" where username == '"+ username +"' and password == '" +password+ "'",null);
        if(cr.getCount()==0){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
