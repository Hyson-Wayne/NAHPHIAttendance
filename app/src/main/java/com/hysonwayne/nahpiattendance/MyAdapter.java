package com.hysonwayne.nahpiattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<UserData> list;


    // constructor for ArrayList
    public MyAdapter(Context context, ArrayList<UserData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UserData user = list.get(position);
        holder.fullName.setText(user.getFullName());
        holder.registrationNumber.setText(user.getRegistrationNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullName, registrationNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            fullName= itemView.findViewById(R.id.fullNames);
            registrationNumber = itemView.findViewById(R.id.registrationNumbers);
        }
    }



}
