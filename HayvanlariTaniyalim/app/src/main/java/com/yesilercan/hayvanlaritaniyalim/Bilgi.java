package com.yesilercan.hayvanlaritaniyalim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Bilgi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi);
    }

    public void turn(View view){

        Intent intent = new Intent(Bilgi.this,MainActivity.class);
        startActivity(intent);
    }

}
