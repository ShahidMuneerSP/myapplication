package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.myapplication.R;

public class PopUpMenuEx extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_menu_ex);
        Button btn=(Button) findViewById(R.id.btnshow1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup=new PopupMenu(PopUpMenuEx.this,v);
                popup.setOnMenuItemClickListener(PopUpMenuEx.this);
                popup.inflate(R.menu.popup);
                popup.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item:"+item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.search_item:
                return true;
            case R.id.upload_item:
                return true;
            case R.id.copy_item:
                return true;
            case R.id.print_item:
            return true;
            case R.id.share_item:
            return true;
            case R.id.bookmark_item:
                return true;
            default:return false;

        }
    }
}