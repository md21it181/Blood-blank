package com.myapp.idonor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.myapp.idonor.donor_form.DonorFormActivity;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText email, password;
    Button login, register;

    ProgressDialog progressDialog;

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

        if(!(user.equals(""))){
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(Login.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                progressDialog.setCancelable(false);
                loginData();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(Login.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
                progressDialog.setCancelable(false);

                registerData();
            }
        });
    }
    public void registerData(){
        final RequestQueue requestQueue = Volley.newRequestQueue(Login.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://smart-blood-4.000webhostapp.com/register.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("inserted")) {
                    SharedPreferences sharedpreferences = getSharedPreferences("db", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("email",email.getText().toString());

                    editor.commit();

                    Toast.makeText(Login.this, "Registered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }else{
                }

                progressDialog.cancel();


                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                requestQueue.stop();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("email",email.getText().toString());
                params.put("password",password.getText().toString());

                return params;
            }
        };

        requestQueue.add(stringRequest);

    }
    public void loginData(){
        final RequestQueue requestQueue = Volley.newRequestQueue(Login.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://smart-blood-4.000webhostapp.com/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("incorrect")) {
                    Toast.makeText(Login.this, "Incorrect information.", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences sharedpreferences = getSharedPreferences("db", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("email",email.getText().toString());

                    editor.commit();

                    Toast.makeText(Login.this, "Registered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, MainActivity.class));
                    finish();
                }

                progressDialog.cancel();


                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                requestQueue.stop();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("email",email.getText().toString());
                params.put("password",password.getText().toString());

                return params;
            }
        };

        requestQueue.add(stringRequest);

    }
}