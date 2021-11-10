package com.myapp.idonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.myapp.idonor.donor_form.DonorFormActivity;
import com.myapp.idonor.donor_list.DonorListActivity;
import com.myapp.idonor.request_blood.RequestBloodActivity;

public class MainActivity extends AppCompatActivity{


    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpreferences = getSharedPreferences("db", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("email","");

                editor.commit();

                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });


    }
    public void df(View view)
    {
        startActivity(new Intent(this, DonorFormActivity.class));
    }
    public void dl(View view)
    {
        startActivity(new Intent(this, DonorListActivity.class));
    }
    public void rb(View view)
    {
        startActivity(new Intent(this, RequestBloodActivity.class));
    }



}
