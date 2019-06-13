package com.zoom.kiki.outofline;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class MainActivity extends AppCompatActivity {
    private Button backButton;
    private Button mapButton;
    private Button toastButton2;
    private Button movieButton;
    private Button camButton;
    private Button signInButton;
    private Button registerButton;

    private EditText name;
    private EditText email;
    private EditText password;

    private FirebaseAuth mAuth;

    public static final String EXTRA_TEXT = "com.zoom.kiki.outofline.EXTRA_TEXT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        backButton = (Button) findViewById(R.id.back_button);
        signInButton = (Button) findViewById(R.id.signin_button);
        registerButton = (Button) findViewById(R.id.register_button);
        mapButton = (Button) findViewById(R.id.mapButton);
        toastButton2 = (Button) findViewById(R.id.toastButton2);
        movieButton = (Button) findViewById(R.id.movieButton);
        camButton = (Button) findViewById(R.id.camButton);
        name = (EditText) findViewById(R.id.name_input);
        email = (EditText) findViewById(R.id.email_input);
        password = (EditText) findViewById(R.id.password_input);



        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

*/
        /*signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(isEmpty()) return;
                mAuth.signInAll(name.getText().toString(),
                        email.getText().toString(),
                        password.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>(){
                            public void OnSuccess(AuthResult authResult){
                                Toast.makeText(MainActivity.this, "User signed in", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, TeamActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            }

                        }


            }

        });*/

       signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                signIn();
            }

        });

        movieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openMovieActivity();
            }

        });

        camButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openCamActivity();
            }

        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openMapActivity();
            }

        });

        /*mapButton.setOnClickListener(new View.OnClickListener() {
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
*/
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

    /*public void openSecondActivity(){
        EditText editText1 = (EditText) findViewById(R.id.EditText1);
        String text = editText1.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        startActivity(intent);
    }*/

    public void openMovieActivity(){
        Intent intent = new Intent(this, MovieActivity.class);
        startActivity(intent);
    }

    public void openCamActivity(){
        Intent intent = new Intent(this, CamActivity.class);
        startActivity(intent);
    }

    public void openMapActivity(){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    private void signIn() {
        // validate name, email, & password fields

        // store name, email, & password values

        // sign into Firebase projecg
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("FIREBASE", "signIn:onComplete:" + task.isSuccessful());

                        if (task.isSuccessful()) {
                            // update profile
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(name)
                                    .build();

                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d("FIREBASE", "User profile updated.");
                                                // Go to FirebaseActivity
                                                startActivity(new Intent(MainActivity.this, TeamActivity.class));
                                            }
                                        }
                                    });

                        } else {
                            Log.d("FIREBASE", "sign-in failed");

                            Toast.makeText(MainActivity.this, "Sign In Failed",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private boolean isEmpty(){
        if(TextUtils.isEmpty(name.getText().toString())){
            name.setError("Required");
            return true;
        }

        if(TextUtils.isEmpty(email.getText().toString())){
            email.setError("Required");
            return true;
        }

        return false;


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

