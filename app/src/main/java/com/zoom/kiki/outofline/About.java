package com.zoom.kiki.outofline;

<<<<<<< Updated upstream
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.support.v7.app.ActionBar;
import android.view.MenuInflater;
public class About extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //connecting the toolbar layout
=======
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

>>>>>>> Stashed changes
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About");

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


<<<<<<< Updated upstream
        };
=======
    };
>>>>>>> Stashed changes



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_movie_list_scrolling, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
