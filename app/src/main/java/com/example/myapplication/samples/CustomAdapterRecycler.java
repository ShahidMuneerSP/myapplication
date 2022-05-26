package com.example.myapplication.samples;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomAdapterRecycler extends RecyclerView.Adapter<CustomAdapterRecycler.MyViewHolder> {
ArrayList<Integer> personimages;
ArrayList<String> personnames;
Context context;
    public CustomAdapterRecycler(Context applicationContext, ArrayList<Integer> personimages, ArrayList<String> personnames) {
        context = applicationContext;
        this.personimages =personimages;
        this.personnames =personnames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.secondrecycler,parent,false);
        MyViewHolder vh=new MyViewHolder(v);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.pnames.setText(personnames.get(position));
        holder.pimage.setImageResource(personimages.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), personnames.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return personnames.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder {
        TextView pnames;
        ImageView pimage;
        public MyViewHolder(View itemView){
            super(itemView);
            pnames=(TextView)itemView.findViewById(R.id.pname);
            pimage=(ImageView) itemView.findViewById(R.id.pimage);

        }
    }
}
