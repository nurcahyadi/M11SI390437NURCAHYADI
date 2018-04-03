package com.example.android.m11si390437nurcahyadi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dataHelper;
    TextView a,b,c,d,e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        dataHelper = new DataHelper(this);
        a = (TextView) findViewById(R.id.textView1);
        b = (TextView) findViewById(R.id.textView2);
        c = (TextView) findViewById(R.id.textView3);
        d = (TextView) findViewById(R.id.textView4);
        e = (TextView) findViewById(R.id.textView5);

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

    public void back(View view) {
        finish();
    }
}