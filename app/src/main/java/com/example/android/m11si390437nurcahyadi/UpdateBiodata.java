package com.example.android.m11si390437nurcahyadi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    EditText a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        dataHelper = new DataHelper(this);

        a = findViewById(R.id.no);
        b = findViewById(R.id.nama);
        c = findViewById(R.id.tglahir);
        d = findViewById(R.id.jk);
        e = findViewById(R.id.alamat);

        SQLiteDatabase db = dataHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+
                getIntent().getStringExtra("nama")+"'",null);

        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            a.setText(cursor.getString(0).toString());
            b.setText(cursor.getString(1).toString());
            c.setText(cursor.getString(2).toString());
            d.setText(cursor.getString(3).toString());
            e.setText(cursor.getString(4).toString());
        }

    }

    public void update(View view) {
        SQLiteDatabase db = dataHelper.getWritableDatabase();
        db.execSQL("UPDATE biodata set nama='"+
                b.getText().toString()+"', tgl = '"+
                c.getText().toString()+"', jk = '"+
                d.getText().toString()+"', alamat = '"+
                e.getText().toString()+"' where no = '"+
                a.getText().toString()+"'"
        );
        Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();
        MainActivity.ma.RefreshList();
        finish();
    }

    public void back(View view) {
        finish();
    }
}