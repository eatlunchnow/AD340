package com.zoom.kiki.outofline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        TextView textview1 = (TextView) findViewById(R.id.textView1);

        textview1.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();


        inflater.inflate(R.menu.menu_movie_list_scrolling, menu);


        return super.onCreateOptionsMenu(menu);

    }

}
