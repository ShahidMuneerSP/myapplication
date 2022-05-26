package com.example.myapplication.samples;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.text.BreakIterator;

public class CustomAdapterCard2 extends RecyclerView.Adapter<CustomAdapterCard2.MyViewHolder1> {
    private final String[] personNames;
    int[] personImages;
    Context context;

    public CustomAdapterCard2(CardWithRecycler cardWithRecycler, String[] personNames, int[] personImages) {
        this.context =context;
        this.personNames=personNames;
        this.personImages=personImages;
    }

    @Override
    public MyViewHolder1 onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayoutcard,parent,false);
        MyViewHolder1 vh=new MyViewHolder1(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder1 holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(personNames[position]);
        holder.image.setImageResource(personImages[position]);
        holder.view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,SecondActivtyCard.class);
                intent.putExtra("image",personImages[position]);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        public View view;
        TextView name;
        ImageView image;

        public MyViewHolder1(View view) {
            super(view);

            name=(TextView) view.findViewById(R.id.name);
            image=(ImageView) view.findViewById(R.id.image);
        }
    }
}
