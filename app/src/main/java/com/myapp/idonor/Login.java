package com.myapp.idonor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText email, password;
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        @SuppressLint("WrongConstant") SharedPreferences sh = getSharedPreferences("db", MODE_APPEND);
        String user = sh.getString("email", "");

        if(user.equals("admin")){
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("admin") && email.getText().toString().equals("admin")) {
                    SharedPreferences sharedpreferences = getSharedPreferences("db", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("email",email.getText().toString());

                    editor.commit();

                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();

                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(new Intent(Login.this, MainActivity.class));
                finish();
            }
        });
    }
}