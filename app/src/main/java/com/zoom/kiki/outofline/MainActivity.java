package com.zoom.kiki.outofline;
import android.media.Image;
import android.support.v7.widget.Toolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;	import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button toastButton1;
    private Button toastButton2;
    private Button movieButton;


    public static final String EXTRA_TEXT = "com.zoom.kiki.outofline.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connecting the toolbar layout
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        button = (Button) findViewById(R.id.button);
        toastButton1 = (Button) findViewById(R.id.toastButton1);
        toastButton2 = (Button) findViewById(R.id.toastButton2);
        movieButton = (Button) findViewById(R.id.movieButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

        movieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openMovieActivity();
            }

        });

        toastButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);

                toast.show();

            }
        });

        toastButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast_layout2, (ViewGroup) findViewById(R.id.toast_root2));

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);

                toast.show();

            }
        });


/*
        ImageButton infoIcon = (ImageButton) findViewById(R.id.info_icon);

        infoIcon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                openAboutActivity();
                //setContentView(R.layout.activity_about);
            }

        });*/
    }




    public void showToast(){

    }

    public void openAboutActivity(){

        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    public void openSecondActivity(){
        EditText editText1 = (EditText) findViewById(R.id.EditText1);
        String text = editText1.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }

    public void openMovieActivity(){
        Intent intent = new Intent(this, MovieActivity.class);
        startActivity(intent);
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



                default:


            }


        return super.onOptionsItemSelected(item);
    }



}
