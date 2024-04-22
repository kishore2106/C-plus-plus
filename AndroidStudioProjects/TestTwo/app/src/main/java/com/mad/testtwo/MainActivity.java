package com.mad.testtwo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ProgressBar pg;
    int curprg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        pg = findViewById(R.id.progressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer t = new Timer();
                TimerTask tt = new TimerTask() {
                    @Override
                    public void run() {
                        curprg+=5;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pg.setProgress(curprg);
                                if(curprg == 100){
                                    Log.e("",String.valueOf(curprg));
                                    t.cancel();
                                    showCompletionMessage();
                                }
                            }
                        });
                    }
                };
                t.schedule(tt,0,100);
            }
        });

    }

    private void showCompletionMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Progress Completed!")
                .setTitle("Pop up")
                .setNegativeButton("Close app",(dialog, which)->{
                    finish();
                })
                .setPositiveButton("OK",null)
                .create()
                .show();

    }
}