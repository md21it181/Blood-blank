package com.myapp.idonor.donor_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.myapp.idonor.R;

import java.util.HashMap;
import java.util.Map;

public class DonorFormActivity extends AppCompatActivity {

    EditText name, dob, weight, number;
    Spinner gender, group;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_form);

        name = findViewById(R.id.name);
        dob = findViewById(R.id.dob);
        weight = findViewById(R.id.bw);
        number = findViewById(R.id.cn);
        gender = findViewById(R.id.ceta);
        group = findViewById(R.id.d);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set_data();
            }
        });



    }
    public void set_data(){
        final RequestQueue requestQueue = Volley.newRequestQueue(DonorFormActivity.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://smart-blood-4.000webhostapp.com/add_donor.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("inserted")) {


                    Toast.makeText(DonorFormActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                   }




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

                params.put("name",name.getText().toString());
                params.put("dob",dob.getText().toString());
                params.put("gender",gender.getSelectedItem().toString());
                params.put("weight",weight.getText().toString());
                params.put("number",number.getText().toString());
                params.put("group",group.getSelectedItem().toString());

                return params;
            }
        };

        requestQueue.add(stringRequest);

    }
}
