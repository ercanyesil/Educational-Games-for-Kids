package com.yesilercan.hayvanlaritaniyalim;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Oyun extends AppCompatActivity {

    TextView scoreText;
    TextView timeText;
    int score;
    ImageView carrot1;
    ImageView carrot2;
    ImageView carrot3;
    ImageView carrot4;
    ImageView carrot5;
    ImageView carrot6;
    ImageView carrot7;
    ImageView carrot8;
    ImageView carrot9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun);

        timeText = findViewById(R.id.timeText3);
        scoreText = findViewById(R.id.scoreText3);
        carrot1 = findViewById(R.id.fish1);
        carrot2 = findViewById(R.id.fish2);
        carrot3 = findViewById(R.id.fish3);
        carrot4 = findViewById(R.id.fish4);
        carrot5 = findViewById(R.id.fish5);
        carrot6 = findViewById(R.id.fish6);
        carrot7 = findViewById(R.id.fish7);
        carrot8 = findViewById(R.id.fish8);
        carrot9 = findViewById(R.id.fish9);

        imageArray = new ImageView[] {carrot1,carrot2,carrot3,carrot4,carrot5,carrot6,carrot7,carrot8,carrot9};

        hideImages();

        score = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Süre : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                timeText.setText("Süre Bitti");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(Oyun.this);

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
                        Intent intent = new Intent(Oyun.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Oyun.this, "Oyun Bitti ! Ana sayfaya yönlendiriliyorsunuz..", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();

            }
        }.start();
        
    }


    public void increasedScore(View view){

        score++;

        scoreText.setText("Mahsül : " + score);

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
