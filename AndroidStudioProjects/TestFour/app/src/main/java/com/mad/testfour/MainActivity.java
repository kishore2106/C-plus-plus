package com.mad.testfour;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Button frag1,frag2;
    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = findViewById(R.id.fragonebtn);
        frag2 = findViewById(R.id.fragtwobtn);
        constraintLayout = findViewById(R.id.cls);

        frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentOne = new FragmentOne();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.cls,fragmentOne).commit();
            }
        });

        frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTwo = new FragmentTwo();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.cls,fragmentTwo).commit();
            }
        });
    }
}