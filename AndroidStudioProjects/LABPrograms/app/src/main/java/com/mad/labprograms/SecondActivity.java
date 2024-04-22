package com.mad.labprograms;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String age = i.getStringExtra("age");

        TextView t1 = findViewById(R.id.textView1);
        TextView t2 = findViewById(R.id.textView2);

        t1.setText(name);
        t2.setText(age);

    }

}
