package com.example.myapplication.samples;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class NetworkConnectivityActivity extends AppCompatActivity {


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_connectivity);

        CheckNetwork network = new CheckNetwork(getApplicationContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            network.registerNetworkCallback();

        }
    }
    public void checknetworkstate(View v) {
        if (Variables.isNetworkConnected) {
            Toast.makeText(getApplicationContext(), "Internet is connected", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Internet is not connected", Toast.LENGTH_LONG).show();
        }
    }

}
class Variables{
    public static boolean isNetworkConnected = false;
}
class  CheckNetwork{
    private final Context context;

    public CheckNetwork(Context context){
        this.context = context;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void registerNetworkCallback() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() {

                @Override

                public void onAvailable(Network network) {
                    Variables.isNetworkConnected = true;
                }

                @Override
                public void onLost(Network network) {
                    Variables.isNetworkConnected = false;
                }
            });
            Variables.isNetworkConnected=false;

    } catch (Exception e){
            Variables.isNetworkConnected=false;
        }

    }

}
