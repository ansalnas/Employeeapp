package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addemployee extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
Button b1;
String getemployee,getname,getdes,getphone;
DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);
        ed1=(EditText)findViewById(R.id.emp);
        ed2=(EditText)findViewById(R.id.name);
        ed3=(EditText)findViewById(R.id.des);
        ed4=(EditText)findViewById(R.id.phn);
        b1= (AppCompatButton)findViewById(R.id.sub);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getemployee=ed1.getText().toString();
                getname=ed2.getText().toString();
                getdes=ed3.getText().toString();
                getphone=ed4.getText().toString();
                boolean status=mydb.insertemployee(getemployee,getname,getdes,getphone);
                if (status=true)
                {
                    Toast.makeText(getApplicationContext(), "successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "something error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}