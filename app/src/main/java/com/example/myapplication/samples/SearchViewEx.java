package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SearchViewEx extends AppCompatActivity {
    SearchView searchView;
    ListView  listView;
        ArrayList<String> list;
        ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_ex);

        searchView =(SearchView) findViewById(R.id.searchView);
        listView =(ListView) findViewById(R.id.lv1);

        list=new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("pineapple");
        list.add("Orange");
        list.add("Lychee");
        list.add("Gavava");
        list.add("Peech");
        list.add("Melon");
        list.add("Watermelone");
        list.add("Papaya");


        adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (list.contains(query)){
                    adapter.getFilter().filter(query);
                }else {
                    Toast.makeText(SearchViewEx.this, "No Match Found", Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }
}