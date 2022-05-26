package com.example.myapplication;

import static android.R.layout.simple_list_item_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    RadioGroup gender;
    RadioButton r1, r2;
    CheckBox c1, c2, c3, c4;
    String states[]= new String[]{"-select state-", "Kerala", "Tamilnadu", "Karnataka", "J&K", "Goa", "Andrapradesh", "Orissa", "Bihar"};
    Spinner sp;
    ListView lv;
    ArrayAdapter arrayAdapter;
    ArrayList districts=new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        gender = (RadioGroup) findViewById(R.id.rg);
        r1 = (RadioButton) findViewById(R.id.female);
        r2 = (RadioButton) findViewById(R.id.male);
        c1 = (CheckBox) findViewById(R.id.checkBox5);
        c2 = (CheckBox) findViewById(R.id.checkBox6);
        c3 = (CheckBox) findViewById(R.id.checkBox7);
        c4 = (CheckBox) findViewById(R.id.checkBox8);
        districts.add("-select district-");
        districts.add("Ernakulam");
        districts.add("Kottayam");
        districts.add("Idukki");
        districts.add("Palakkad");
        districts.add("Malappuram");
        districts.add("Kollam");
        districts.add("kasargod");
        districts.add("Kannur");


        sp=(Spinner)findViewById(R.id.spinner);
        arrayAdapter=new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,states);
        sp.setAdapter(arrayAdapter);


        lv=(ListView)findViewById(R.id.listview) ;
        arrayAdapter= new ArrayAdapter(getApplicationContext(), simple_list_item_2,districts);
        lv.setAdapter(arrayAdapter);

        //click on spinner
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //String items=adapterView.getItemAtPosition(i).toString();
                if (adapterView.getItemAtPosition(i).equals("-select state-")) {

                } else {
                    Toast.makeText(getApplicationContext(), states[i], Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                          String  items=adapterView.getItemAtPosition(i).toString();
                                          if (adapterView.getItemAtPosition(i).equals("-select district-")) {

                                          } else {
                                              Toast.makeText(getApplicationContext(),items, Toast.LENGTH_LONG).show();
                                          }
                                      }
                                  });


       // gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        //    @Override
         //   public void onCheckedChanged(RadioGroup radioGroup, int i) {
           //     RadioButton rb = (RadioButton) findViewById(gender.getCheckedRadioButtonId());
          //      String value = rb.getText().toString();
          //      Toast.makeText(getApplicationContext(), "Gender is " + value, Toast.LENGTH_LONG).show();
         //   }
       // });
        //  gender.setOnClickListener(new View.OnClickListener() {
        //      @Override
        //      public void onClick(View view) {
        //          RadioButton rb=(RadioButton) findViewById(gender.getCheckedRadioButtonId());
        //          String value=rb.getText().toString();
        //           Toast.makeText(getApplicationContext(), "Gender is"+value, Toast.LENGTH_LONG).show();
        //       }
        //    });
        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.female:
                        String value = r1.getText().toString();
                        Toast.makeText(getApplicationContext(), "Gender is" + value, Toast.LENGTH_LONG).show();
                    case R.id.male:
                        String value1 = r1.getText().toString();
                        Toast.makeText(getApplicationContext(), "Gender is" + value1, Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void show(View view) {
        boolean checkedcheckbox = ((CheckBox) view).isChecked();

        String lang = "";
        switch (view.getId()) {
            case R.id.checkBox5:
                lang = checkedcheckbox ? "Malayalam Selected" : "Malayalam Deselected";
                break;
            case R.id.checkBox6:
                lang = checkedcheckbox ? "English Selected" : "English Deselected";
                break;
            case R.id.checkBox7:
                lang = checkedcheckbox ? "Hindi Selected" : "Hindi Deselected";
                break;
            case R.id.checkBox8:
                lang = checkedcheckbox ? "Tamil Selected" : "Tamil Deselected";
                break;

    }
       Toast.makeText(getApplicationContext(), "Languages known are"+lang,Toast.LENGTH_LONG).show();

}
    public void display(View view) {
        String langg = "selected languages are";
        if(c1.isChecked()) {
            langg += "Malayalam";
        }
        if(c2.isChecked()) {
            langg += "English";
        }
        if(c3.isChecked()) {
            langg += "Hindi";
        }
        if(c4.isChecked()) {
            langg += "Tamil";
        }
        Toast.makeText(getApplicationContext(), "Languages known are"+langg, Toast.LENGTH_SHORT).show();
    }

}

