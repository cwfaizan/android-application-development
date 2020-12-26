package com.pf.tutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.jetbrains.annotations.NotNull;

public class DatabaseFactory extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tutorial.db";

    public DatabaseFactory (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NotNull SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS user ( id INTEGER PRIMARY KEY AUTOINCREMENT, pp BLOB)");
    }

    @Override
    public void onUpgrade(@NotNull SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);

    }

    public boolean save(int id, byte[] pp){
        try {
            ContentValues cv = new ContentValues();
            cv.put("id", id);
            cv.put("pp", pp );
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert("user", null, cv);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(int id, byte[] pp){
        try{
            ContentValues cv = new ContentValues();
            cv.put("pp", pp );
            SQLiteDatabase db = this.getWritableDatabase();
            db.update("user", cv, "id=?", new String[]{ String.valueOf(id) } );
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    public User getUser(String query){
        try
        {
            User user = null;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()){

                int id = cursor.getInt(0);
                byte[] pp = cursor.getBlob(1);

                user = new User(id, pp);
            }
            return user;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
