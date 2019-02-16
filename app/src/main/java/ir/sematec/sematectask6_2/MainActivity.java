package ir.sematec.sematectask6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Thread","Thread.currentThread().getName()");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Thread","Thread.currentThread().getName()");

            }
        }).start();
    }
}
