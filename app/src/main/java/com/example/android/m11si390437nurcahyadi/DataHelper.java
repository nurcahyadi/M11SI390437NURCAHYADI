package com.example.android.m11si390437nurcahyadi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Umam on 4/2/2018.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "biodatadiri.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE biodata(no integer primary key, nama text null, tgl text null, jk text null" +
                ",alamat text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);

        sql = "INSERT INTO biodata (no, nama, tgl, jk, alamat) VALUES ('1001','Fathur','1994-02-03','Laki-Laki','Jakarta');";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
