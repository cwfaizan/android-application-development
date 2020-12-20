package com.pf.tutorial;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFactory extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "test.db";

    public DatabaseFactory (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table(s)
        db.execSQL("CREATE TABLE country ( code INTEGER PRIMARY KEY, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS country");
        // Create table(s) again after drop
        onCreate(db);
    }

    public int insertUpdateDeleteCountry(String query){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(query);
            db.close();
            return 1;
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public Cursor selectCountry(String query){
        try{
            SQLiteDatabase db = this.getReadableDatabase();
            return db.rawQuery(query, null);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
