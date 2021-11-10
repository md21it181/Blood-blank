package com.myapp.idonor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.myapp.idonor.donor_form.DonorFormActivity;
import com.myapp.idonor.donor_list.DonorListActivity;
import com.myapp.idonor.request_blood.RequestBloodActivity;

public class MainActivity extends AppCompatActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
