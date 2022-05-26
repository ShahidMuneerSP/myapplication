package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
    Button login;
    EditText username;
    EditText password;
    String un = "admin";
    String pw="123123" ;
    TextView labeltext;

    int clickcount=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login = (Button) findViewById(R.id.button2);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        labeltext=(TextView) findViewById(R.id.labeltext);

        //       login.setOnClickListener(new View.OnClickListener() {
        //           @Override
        //           public void onClick(View view) {
        //               Intent i=new Intent(LoginPage.this,HomePage.class);
        //               startActivity(i);
        //           }
        //       });

        //          }

        //
         //Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_LONG).show();
         // }
        login.setOnClickListener(this);

        Intent intentfromreg = getIntent();
        un = intentfromreg.getStringExtra("username");
        pw =intentfromreg.getStringExtra("password");
        password.setEnabled(true);
        username.setText(un);
        password.setText(pw);
    }


        public void login (View vew){
            String uname = username.getText().toString();
            String paswd = password.getText().toString();


            if (uname.equals(un) && password.equals(pw)) {
                Intent i = new Intent(getApplicationContext(),HomePage.class);
                i.putExtra("user", uname);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "invalid username or password", Toast.LENGTH_LONG).show();
                clickcount--;
                if (clickcount == 0) {
                    login.setEnabled(false);
                    labeltext.setText("LOGIN BLOCKED");


                }
            }
    }

    @Override
    public void onClick(View view) {
finish();
    }

    public void gotoregister(View view) {
        Intent i=new Intent(getApplicationContext(),Registration.class);
        startActivity(i);
    }
}
