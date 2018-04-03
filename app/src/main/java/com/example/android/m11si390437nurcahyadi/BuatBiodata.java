package com.example.android.m11si390437nurcahyadi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {

    protected Cursor cursor;
    DataHelper dataHelper;
    EditText a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dataHelper = new DataHelper(this);
        a = findViewById(R.id.no);
        b = findViewById(R.id.nama);
        c = findViewById(R.id.tglahir);
        d = findViewById(R.id.jk);
        e = findViewById(R.id.alamat);
    }

    public void simpan(View view) {
        SQLiteDatabase db = dataHelper.getWritableDatabase();

        db.execSQL("insert into biodata (no, nama, tgl, jk, alamat) values ('" +
                a.getText().toString()+"','"+
                b.getText().toString()+"','"+
                c.getText().toString()+"','"+
                d.getText().toString()+"','"+
                e.getText().toString()+"')"
        );

        Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();
        MainActivity.ma.RefreshList();
        finish();
    }

    public void back(View view) {
        finish();
    }
}

