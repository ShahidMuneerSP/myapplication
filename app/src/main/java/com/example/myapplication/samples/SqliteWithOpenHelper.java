package com.example.myapplication.samples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;

public abstract class SqliteWithOpenHelper extends AppCompatActivity {
    private EditText courseNameEdt,courseTracksEdt,courseDurationEdt,courseDescriptionEdt;
    private Button addCourseBtn,readCourseBtn;
    private DBHandler dbHandler;

    public SqliteWithOpenHelper(Context context, String dbName, Object o, int dbVersion) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_with_open_helper);
        courseNameEdt= findViewById(R.id.idEdtCourseName);
        courseTracksEdt= findViewById(R.id.idEdtCourseTracks);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseDescriptionEdt=findViewById(R.id.idEdtCourseDescription);
        addCourseBtn =findViewById(R.id.idBtnAddCourse);
        readCourseBtn = findViewById(R.id.idBtnReadCourse);
        dbHandler =new DBHandler(SqliteWithOpenHelper.this);
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName= courseNameEdt.getText().toString();
                String courseTracks= courseTracksEdt.getText().toString();
                String courseDuration= courseDurationEdt.getText().toString();
                String courseDescription=courseDescriptionEdt.getText().toString();

                if (courseName.isEmpty() && courseTracks.isEmpty() && courseDuration.isEmpty() && courseDescription.isEmpty()){
                    Toast.makeText(SqliteWithOpenHelper.this, "Please enter all the data ..", Toast.LENGTH_SHORT).show();
                    return;
                }
                dbHandler.addNewCourse(courseName,courseDuration,courseDescription,courseTracks);

                Toast.makeText(SqliteWithOpenHelper.this, "Course has been added", Toast.LENGTH_SHORT).show();
                courseNameEdt.setText("");
                courseDurationEdt.setText("");
                courseTracksEdt.setText("");
                courseDescriptionEdt.setText("");

                
            }
        });
        readCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SqliteWithOpenHelper.this,ViewCourses.class);
                startActivity(i);
            }
        });

    }

    protected abstract void onCreate(SQLiteDatabase db);

    public abstract ArrayList<CourseModel> readCourses();

    protected abstract SQLiteDatabase getReadableDatabase();

}