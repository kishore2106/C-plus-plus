package com.mad.labfive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,reg;
    boolean result;
    EditText name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.unamebtn);
        pass = findViewById(R.id.pwdbtn);
        login = findViewById(R.id.loginbtn);
        reg = findViewById(R.id.regbtn);

        sqldb db=new sqldb(MainActivity.this);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=db.addUser(name.getText().toString(),pass.getText().toString());
                if (result)
                    Toast.makeText(MainActivity.this,"Registration Done Successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Some Error Occured while Registering",Toast.LENGTH_SHORT).show();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = db.getData(name.getText().toString(), pass.getText().toString());
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