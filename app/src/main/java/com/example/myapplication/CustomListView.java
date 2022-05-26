package com.example.myapplication;

import static com.example.myapplication.R.menu.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CustomListView extends AppCompatActivity {
    ListView flist;
    String foodnames[]={"Apple","Banana","Orange","Watermelon","Grapes","Donut","Mango","Pinapple"};
    int foodimages[] ={R.drawable.fruitapple,R.drawable.fruitbanana,R.drawable.fruitorange,R.drawable.fruitwatermelone,R.drawable.grape,R.drawable.donut,R.drawable.mango,R.drawable.pinapple};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        flist =(ListView) findViewById(R.id.foodlist);
        CustomAdapter customAdapter =new CustomAdapter(getApplicationContext(),foodimages,foodnames);
        flist.setAdapter(customAdapter);

        flist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("EXIT?");
        alert.setMessage("Do you want to exit?");
        alert.setCancelable(false);
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        alert.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog obj = alert.create();
        obj.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.select:
                Toast.makeText(getApplicationContext(), " selected", Toast.LENGTH_LONG).show();
            case R.id.copy:
                Toast.makeText(getApplicationContext(), " copied", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}