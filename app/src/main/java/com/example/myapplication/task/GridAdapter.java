package com.example.myapplication.task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import javax.xml.namespace.QName;

public class GridAdapter extends BaseAdapter {
    private final Context mContext;

    public Integer[] thumbImages = {
            R.drawable.spanish, R.drawable.budget,
            R.drawable.healthy_pasta, R.drawable.british_food,
            R.drawable.roast, R.drawable.mojito,
    };

    public GridAdapter(Context c) {
        mContext =c;
    }

    public int getCount() {

        return thumbImages.length;
    }
    public Object getItem(int position)
    {
        return null;
    }
    public long getItemId(int position) {

        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(thumbImages[position]);

        return imageView;
    }

}

