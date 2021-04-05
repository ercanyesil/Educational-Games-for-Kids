package com.yesilercan.hayvanlaritaniyalim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hedefler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hedefler);
    }

    public void turn2(View view){

        Intent intent = new Intent(Hedefler.this,MainActivity.class);
        startActivity(intent);
    }
}