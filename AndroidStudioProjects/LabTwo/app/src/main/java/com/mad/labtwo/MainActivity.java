package com.mad.labtwo;

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

    int curprg = 0;
    Button btn;
    ProgressBar pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.Startbtn);
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
                                if(curprg==100){
                                    Log.e("",String.valueOf(curprg));
                                    t.cancel();
                                    showMessageCompletion();
                                }
                            }
                        });
                    }
                };
                t.schedule(tt,0,100);
            }
        });

    }
    public void showMessageCompletion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Process Completed!")
                .setTitle("Pop up")
                .setNegativeButton("Close app",(dialog, which) ->{
                    finish();
                } )
                .setPositiveButton("OK",null)
                .create()
                .show();
    }
}