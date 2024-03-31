package com.mad.labsix;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText mob,msg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mob = findViewById(R.id.mobile);
        msg = findViewById(R.id.msg);
        btn = findViewById(R.id.send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    requestPermission();
                    SmsManager smsm = SmsManager.getDefault();
                    smsm.sendTextMessage(mob.getText().toString(),null,msg.getText().toString(),null,null);
                    Toast.makeText(MainActivity.this, "SMS Sent Successfully", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Log.i("INFO LOG",e.toString());
                    Toast.makeText(MainActivity.this, "Error Sending Message", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void requestPermission(){
        String permissionStr = "android.permission.SEND_SMS";

        if(ContextCompat.checkSelfPermission(this, permissionStr)!= PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[] {permissionStr},1);
        }
    }
}