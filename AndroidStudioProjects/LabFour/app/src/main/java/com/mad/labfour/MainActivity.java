package com.mad.labfour;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    ConstraintLayout csl;
    Button frag1,frag2;

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frag1 = findViewById(R.id.btn);
        frag2 = findViewById(R.id.btn2);

        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentOne = new FragmentOne();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.cslayout,fragmentOne).commit();
            }
        });

        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTwo = new FragmentTwo();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.cslayout,fragmentTwo).commit();
            }
        });
    }
}