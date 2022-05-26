package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.CustomAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;

public class CardWithRecycler extends AppCompatActivity {
    String[] personNames ={"Person 1","Person 2","Person 3","Person 4",
            "Person 5","Person 6","Person 7","Person 8","Person 9","Person 10","Person 11",
            "Person 12","Person 13","Person 14"};
    int[] personImages ={R.drawable.person1,R.drawable.person2,R.drawable.person3,
            R.drawable.person4,R.drawable.person5,R.drawable.person6,
            R.drawable.person7,R.drawable.person1,R.drawable.person2,
            R.drawable.person3,R.drawable.person4,R.drawable.person5,
            R.drawable.person6,R.drawable.person7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_with_recycler);

        RecyclerView recyclerView=(RecyclerView)  findViewById(R.id.recyclerview1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        CustomAdapterCard2 customAdapter=new CustomAdapterCard2(CardWithRecycler.this,personNames,personImages);
        recyclerView.setAdapter(customAdapter);
    }
}