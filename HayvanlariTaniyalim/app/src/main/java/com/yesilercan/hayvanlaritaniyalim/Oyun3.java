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

public class Oyun3 extends AppCompatActivity {

    TextView scoreText3;
    TextView timeText3;
    int score3;
    ImageView fish1;
    ImageView fish2;
    ImageView fish3;
    ImageView fish4;
    ImageView fish5;
    ImageView fish6;
    ImageView fish7;
    ImageView fish8;
    ImageView fish9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun3);

        timeText3 = findViewById(R.id.timeText3);
        scoreText3 = findViewById(R.id.scoreText3);
        fish1 = findViewById(R.id.fish1);
        fish2 = findViewById(R.id.fish2);
        fish3 = findViewById(R.id.fish3);
        fish4 = findViewById(R.id.fish4);
        fish5 = findViewById(R.id.fish5);
        fish6 = findViewById(R.id.fish6);
        fish7 = findViewById(R.id.fish7);
        fish8 = findViewById(R.id.fish8);
        fish9 = findViewById(R.id.fish9);

        imageArray = new ImageView[] {fish1,fish2,fish3,fish4,fish5,fish6,fish7,fish8,fish9};

        hideImages();

        score3 = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText3.setText("Süre : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                timeText3.setText("Süre Bitti");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(Oyun3.this);

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
                        Intent intent = new Intent(Oyun3.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Oyun3.this, "Oyun Bitti ! Ana sayfaya yönlendiriliyorsunuz..", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();

            }
        }.start();

    }


    public void increasedScore(View view){

        score3++;

        scoreText3.setText("Mahsül : " + score3);

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
