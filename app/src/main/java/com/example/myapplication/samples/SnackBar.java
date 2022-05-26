package com.example.myapplication.samples;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackBar extends AppCompatActivity {
    ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);

        constraintLayout =findViewById(R.id.constraint);

        findViewById(R.id.buttonSnackbar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar =Snackbar.make(constraintLayout,"",Snackbar.LENGTH_LONG);
                View custom =getLayoutInflater().inflate(R.layout.snackbar_custom,null);
                snackbar.getView().setBackgroundColor(Color.TRANSPARENT);
                Snackbar.SnackbarLayout snackbarLayout=(Snackbar.SnackbarLayout)  snackbar.getView();
                snackbarLayout.setPadding(0,0,0,0);

                (custom.findViewById(R.id.subscribe)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Thanks for subscribe", Toast.LENGTH_SHORT).show();
                        snackbar.dismiss();
                    }
                });
                snackbarLayout.addView(custom,0);
                snackbar.show();
            }
        });
    }
}