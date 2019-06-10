package com.zoom.kiki.outofline;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class CamActivity extends AppCompatActivity {

    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam);

        if(haveNetwork()){
            Toast.makeText(CamActivity.this, "Network connection", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CamActivity.this, "No network connection", Toast.LENGTH_SHORT).show();
        }


        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.fetcheddata);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData process = new fetchData();
                process.execute();
            }
        });
    }

    private boolean haveNetwork(){
        boolean have_Wifi = false;
        boolean have_Data = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo infor : networkInfos) {
            if (infor.getTypeName().equalsIgnoreCase("Wifi"))
                if (infor.isConnected())
                    have_Wifi = true;
            if (infor.getTypeName().equalsIgnoreCase("Data"))
                if(infor.isConnected())
                    have_Data = true;
        }

        return have_Data || have_Wifi;
    }

}

