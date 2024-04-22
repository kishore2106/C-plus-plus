package com.mad.labprograms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        EditText t1 = findViewById(R.id.editTextText);
        EditText t2 = findViewById(R.id.editTextText2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dname = t1.getText().toString();
                String dage = t2.getText().toString();

                Intent i = new Intent(MainActivity.this,SecondActivity.class);

                i.putExtra("name",dname);
                i.putExtra("age",dage);

                startActivity(i);
            }
        });

    }
}