package com.myapp.idonor.donor_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.myapp.idonor.R;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class DonorListActivity extends AppCompatActivity implements ItemClickListener {

    Donor_List_Adapter his_adapter;
    RecyclerView rv;
    public List<Donor_Data> hlist = new ArrayList<>() ;
    SearchableSpinner loc_s,bg_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

        rv = findViewById(R.id.rv_his);

        hlist.add(new Donor_Data("B+","9999999999","Surat, Gujarat","Mayur Patel"));
        hlist.add(new Donor_Data("O+","0201927279","Surat, Gujarat","John Patel"));
        hlist.add(new Donor_Data("AB-","9090909090","Surat, Gujarat","Doe Patel"));
        hlist.add(new Donor_Data("B-","9999999999","Surat, Gujarat","Bob Elish"));


        his_adapter = new Donor_List_Adapter(DonorListActivity.this,hlist);
        rv.setLayoutManager(new GridLayoutManager(DonorListActivity.this,1));
        rv.setAdapter(his_adapter);
        his_adapter.setClickListener(this);

        loc_s = findViewById(R.id.loc_spinner);
        loc_s.setTitle("Select location");

        bg_s = findViewById(R.id.bg_spinner);
        bg_s.setTitle("Select blood group");
    }

    public void search(View view){

        String location = loc_s.getSelectedItem().toString();
        String bg = bg_s.getSelectedItem().toString();

        Toast.makeText(this, location+" "+bg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view, int position) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + hlist.get(position).getNumber()));
        startActivity(intent);

    }
}
