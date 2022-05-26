package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int foodimages[];
    String foodnames[];
    LayoutInflater inflater;
    public CustomAdapter(Context applicationContext, int[] foodimages, String[] foodnames) {
        context = applicationContext;
        this.foodimages=foodimages;
        this.foodnames=foodnames;
    }

    @Override
    public int getCount() {
        return foodimages.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(R.layout.secondlayout,null);
        TextView tv=(TextView) view.findViewById(R.id.food);
        ImageView im=(ImageView) view.findViewById(R.id.foodimg);
        tv.setText(foodnames[i]);
        im.setImageResource(foodimages[i]);
        return view;
    }
}


