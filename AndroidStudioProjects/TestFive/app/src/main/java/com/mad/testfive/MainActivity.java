package com.mad.testfive;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button reg,login;

    Boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextUserName);
        password = findViewById(R.id.editTextPassword);
        reg = findViewById(R.id.regbtn);
        login = findViewById(R.id.loginbtn);

        sqldb db = new sqldb(MainActivity.this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = db.addUser(username.getText().toString(),password.getText().toString());
                if(result){
                    Toast.makeText(MainActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = db.getData(username.getText().toString(), password.getText().toString());
                if (result)
                {       Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this,"Invalid Credential",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}