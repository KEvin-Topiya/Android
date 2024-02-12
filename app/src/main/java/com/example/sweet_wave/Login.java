package com.example.sweet_wave;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
Button login;
TextView fpwd;
EditText usr,pwd;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.login);
        usr=findViewById(R.id.usr);
        pwd=findViewById(R.id.pwd);
        fpwd=findViewById(R.id.frgpwd);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usr.getText().toString().equals("RJK") && pwd.getText().toString().equals("RJK") ){
                    startActivity(new Intent(getApplicationContext(), Home.class));
                }
                else{
                    Toast.makeText(Login.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Forgat_pwd.class));
            }
        });



    }
}