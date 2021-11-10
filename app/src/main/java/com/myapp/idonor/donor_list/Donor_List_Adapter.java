package com.myapp.idonor.donor_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.idonor.R;

import java.util.List;

public class Donor_List_Adapter extends RecyclerView.Adapter<Donor_List_Adapter.MyViewHolder> {



    private Context mContext ;


    private ItemClickListener clickListener;
    private List<Donor_Data> mData ;





    public Donor_List_Adapter(Context mContext, List<Donor_Data> mData) {

        this.mContext = mContext;

        this.mData = mData;

        //Toast.makeText(mContext, "hello", Toast.LENGTH_SHORT).show();

    }




    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view ;

        LayoutInflater mInflater = LayoutInflater.from(mContext);

        view = mInflater.inflate(R.layout.item_donor_list,parent,false);



        return new MyViewHolder(view);

    }





    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.bg.setText(mData.get(position).getBg());
        holder.name.setText(mData.get(position).getName());
        holder.city.setText(mData.get(position).getCity());
        //holder.state.setText(mData.get(position).getState());




    }



    @Override

    public int getItemCount() {

        return mData.size();

    }


    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{



      TextView bg,name,city;
      ImageView call_button;






        public MyViewHolder(View itemView) {

            super(itemView);


            bg = (TextView) itemView.findViewById(R.id.bg) ;
            call_button = itemView.findViewById(R.id.call);
            name = itemView.findViewById(R.id.name);
            city = itemView.findViewById(R.id.city);
            //state = itemView.findViewById(R.id.state);












            call_button.setOnClickListener(this);



        }
        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onClick(view, getAdapterPosition());
        }







    }





}