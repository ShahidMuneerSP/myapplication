package com.example.myapplication.samples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

public class ContextMenuEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_ex);
        Button btn=(Button) findViewById(R.id.btnshow);
        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0,v.getId(),0,"Upload");
        menu.add(0,v.getId(),0,"Search");
        menu.add(0,v.getId(),0,"Share");
        menu.add(0,v.getId(),0,"Bookmark");
        menu.add("copy");
        menu.add("selectall");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Selected Item:"+item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}