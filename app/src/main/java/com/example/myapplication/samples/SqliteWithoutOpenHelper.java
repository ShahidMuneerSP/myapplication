package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class SqliteWithoutOpenHelper extends AppCompatActivity {
    EditText des,con,area,city;
    AutoCompleteTextView name;
    Button add,show,update,delete,reset;


SQLiteDatabase db;
private static final String DB_NAME ="myDB.db";
private static final String TABLE_NAME="emp_details";


List<String> item=new ArrayList<String>();
ArrayAdapter<String> adapter;
Cursor cur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_without_open_helper);

        name=(AutoCompleteTextView) findViewById(R.id.edit1);
        des=(EditText) findViewById(R.id.edit2);
        con=(EditText) findViewById(R.id.edit3);
        area=(EditText) findViewById(R.id.edit4);
        city=(EditText) findViewById(R.id.edit5);
        add=(Button) findViewById(R.id.Button1);
        show=(Button) findViewById(R.id.Button2);
        update=(Button) findViewById(R.id.Button3);
        delete=(Button) findViewById(R.id.Button4);
        reset=(Button) findViewById(R.id.Button5);

        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS " +TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,"+"DESIGNATION TEXT ,CONTACT NUMBER,AREA TEXT,CITY TEXT);");

        db.close();
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
            item.clear();
            db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
            cur = db.rawQuery("SELECT NAME FROM" + TABLE_NAME, null);
            cur.moveToFirst();

            while (cur.isAfterLast() == false) {
                String logic = cur.getString(0);
                item.add(logic);
                cur.moveToNext();
            }
            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, item);
            name.setThreshold(1);
            name.setAdapter(adapter);
            db.close();
        }
        });
        add.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick (View v){
                db=openOrCreateDatabase(DB_NAME,Context.MODE_PRIVATE,null);
                db.execSQL("INSERT INTO " +TABLE_NAME+"(UNAME,DESIGNATION,CONTACT,AREA,CITY)"+
                        "VALUES('"+name.getText().toString()
            +"','"+des.getText().toString()+"','"
                +con.getText()+"','"+area.getText().toString()
                +"','"+city.getText().toString()+"')");
                db.close();
                name.getText().clear();
                des.getText().clear();
                con.getText().clear();
                area.getText().clear();
                city.getText().clear();
        }
    });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc=name.getText().toString();
                Intent i=new Intent(SqliteWithoutOpenHelper.this,SqliteViewActivity.class);
                i.putExtra("hello",abc);
                startActivity(i);
                name.getText().clear();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openOrCreateDatabase(DB_NAME,Context.MODE_PRIVATE,null);
                db.execSQL("UPDATE " + TABLE_NAME + " SET DESIGNATION='" + des.getText().toString()
                +"' WHERE NAME='" + name.getText().toString() + "'");
                db.close();
                name.getText().clear();
                des.getText().toString();

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openOrCreateDatabase(DB_NAME,Context.MODE_PRIVATE,null);
            }
        });
}
}