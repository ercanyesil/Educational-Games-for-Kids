package com.yesilercan.hayvanlaritaniyalim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button basla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        basla = findViewById(R.id.basla);


/*
        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rabbitButton.isChecked()){

                    Intent intent = new Intent(MainActivity.this,Oyun.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "TAVŞAN için mahsül toplamaya hazır ol | Oyun başlıyor", Toast.LENGTH_LONG).show();

                }
                else if (beeButton.isChecked()){

                    Intent intent = new Intent(MainActivity.this,Oyun2.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "ARI için mahsül toplamaya hazır ol | Oyun başlıyor", Toast.LENGTH_LONG).show();
                }
                else if (bearButton.isChecked()){

                    Intent intent= new Intent(MainActivity.this,Oyun3.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "AYI için mahsül toplamaya hazır ol | Oyun başlıyor", Toast.LENGTH_LONG).show();
                }


                else{
                    Log.i("SEÇİM HATASI","Seçim belirlenemedi");
                }
            }
        });
*/


    }


    public void changeRabbit(View view){

        Intent intent = new Intent(MainActivity.this,Oyun.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "TAVŞAN için mahsül toplamaya hazır ol | Oyun başlıyor", Toast.LENGTH_LONG).show();
    }

    public void changeBee(View view){

        Intent intent = new Intent(MainActivity.this,Oyun2.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "ARI için mahsül toplamaya hazır ol | Oyun başlıyor", Toast.LENGTH_LONG).show();
    }

    public void changeBear(View view){

        Intent intent = new Intent(MainActivity.this,Oyun3.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "AYI için mahsül toplamaya hazır ol | Oyun başlıyor", Toast.LENGTH_LONG).show();
    }

    public void changeLion(View view){

        Intent intent = new Intent(MainActivity.this,Oyun4.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "AYI için mahsül toplamaya hazır ol | Oyun başlıyor", Toast.LENGTH_LONG).show();
    }

    public void changeActivity(View view){

        Intent intent = new Intent(MainActivity.this,Hedefler.class);
        startActivity(intent);
    }

    public void changeActivity2(View view){

        Intent intent = new Intent(MainActivity.this,Bilgi.class);
        startActivity(intent);
    }

    public void stop(View view){
        ActivityCompat.finishAffinity(MainActivity.this);
    }


}
