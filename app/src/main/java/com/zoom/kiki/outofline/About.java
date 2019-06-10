package com.zoom.kiki.outofline;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.support.v7.app.ActionBar;
import android.view.MenuInflater;
public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_about);
            //connecting the toolbar layout
            Toolbar toolbar = findViewById(R.id.app_bar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("About");

            ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);


        }

    }




