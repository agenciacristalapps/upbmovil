package co.edu.upbmovil.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pasarPantalla();
    }

    private void pasarPantalla() {

        CountDownTimer con = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent in = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(in);
                finish();
            }
        };

        con.start();



    }
}