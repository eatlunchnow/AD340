package com.zoom.kiki.outofline;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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


        click = (Button) findViewById(R.id.back_button);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();


        inflater.inflate(R.menu.menu_movie_list_scrolling, menu);


        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()){
            case R.id.list_settings:
                Intent list = new Intent(this, MovieActivity.class);
                startActivity(list);
                break;
            case R.id.about_settings:
                Intent about = new Intent(this, About.class);
                startActivity(about);
                break;
            case R.id.info_icon:
                Intent aboutIcon = new Intent(this, About.class);
                startActivity(aboutIcon);
                break;
            case R.id.cam_settings:
                Intent camera = new Intent(this, CamActivity.class);
                startActivity(camera);
                break;
            case R.id.map_settings:
                Intent map = new Intent(this, MapActivity.class);
                startActivity(map);
                break;



            default:


        }


        return super.onOptionsItemSelected(item);
    }


}

