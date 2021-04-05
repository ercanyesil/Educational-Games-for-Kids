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

public class Oyun4 extends AppCompatActivity {

    TextView scoreText4;
    TextView timeText4;
    int score4;
    ImageView meat1;
    ImageView meat2;
    ImageView meat3;
    ImageView meat4;
    ImageView meat5;
    ImageView meat6;
    ImageView meat7;
    ImageView meat8;
    ImageView meat9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun4);

        timeText4 = findViewById(R.id.timeText4);
        scoreText4 = findViewById(R.id.scoreText4);
        meat1 = findViewById(R.id.meat1);
        meat2 = findViewById(R.id.meat2);
        meat3 = findViewById(R.id.meat3);
        meat4 = findViewById(R.id.meat4);
        meat5 = findViewById(R.id.meat5);
        meat6 = findViewById(R.id.meat6);
        meat7 = findViewById(R.id.meat7);
        meat8 = findViewById(R.id.meat8);
        meat9 = findViewById(R.id.meat9);

        imageArray = new ImageView[] {meat1,meat2,meat3,meat4,meat5,meat6,meat7,meat8,meat9};

        hideImages();

        score4 = 0;

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText4.setText("Süre : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

                timeText4.setText("Süre Bitti");
                handler.removeCallbacks(runnable);
                for (ImageView image : imageArray) {

                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(Oyun4.this);

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
                        Intent intent = new Intent(Oyun4.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(Oyun4.this, "Oyun Bitti ! Ana sayfaya yönlendiriliyorsunuz..", Toast.LENGTH_SHORT).show();
                    }
                });

                alert.show();

            }
        }.start();

    }


    public void increasedScore(View view){

        score4++;

        scoreText4.setText("Mahsül : " + score4);

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
