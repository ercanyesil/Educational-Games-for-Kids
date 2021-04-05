package com.yesilercan.hayvanlaritaniyalim;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Oyun2 extends AppCompatActivity {

    TextView scoreText2;
    TextView timeText2;
    int score2;
    ImageView flower1;
    ImageView flower2;
    ImageView flower3;
    ImageView flower4;
    ImageView flower5;
    ImageView flower6;
    ImageView flower7;
    ImageView flower8;
    ImageView flower9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun2);

        timeText2 = findViewById(R.id.timeText2);
        scoreText2 = findViewById(R.id.scoreText2);
        flower1 = findViewById(R.id.flower1);
        flower2 = findViewById(R.id.flower2);
        flower3 = findViewById(R.id.flower3);
        flower4 = findViewById(R.id.flower4);
        flower5 = findViewById(R.id.flower5);
        flower6 = findViewById(R.id.flower6);
        flower7 = findViewById(R.id.flower7);
        flower8 = findViewById(R.id.flower8);
        flower9 = findViewById(R.id.flower9);

        imageArray = new ImageView[] {flower1,flower2,flower3,flower4,flower5,flower6,flower7,flower8,flower9};

        hideImages();

        score2 = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText2.setText("Süre : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                timeText2.setText("Süre Bitti");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(Oyun2.this);

                alert.setTitle("Yeniden başlat..");
                alert.setMessage("Mahsül toplamaya hazır mısın?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //restart

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    }
                });

                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Oyun2.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Oyun2.this, "Oyun Bitti ! Ana sayfaya yönlendiriliyorsunuz..", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();

            }
        }.start();


    }

    public void increasedScore(View view){

        score2++;

        scoreText2.setText("Mahsül : " + score2);

    }

    public void hideImages(){

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);
                }

                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,500);

            }
        };

        handler.post(runnable);

    }
}
