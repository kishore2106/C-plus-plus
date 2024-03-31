package com.mad.labthree;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView name;
    TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.textViewName);
        age = findViewById(R.id.textViewAge);

        String welcomeMessage = "Name : "+getIntent().getStringExtra("name");
        name.setText(welcomeMessage);
        age.setText("Age : "+getIntent().getStringExtra("age"));
    }
}