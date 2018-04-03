package com.example.android.m11si390437nurcahyadi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void maps(View view) {
        Intent a = new Intent(Home.this,MapsActivity.class);
        startActivity(a);
    }

    public void sqlite(View view) {
        Intent b = new Intent(Home.this,MainActivity.class);
        startActivity(b);
    }
}
