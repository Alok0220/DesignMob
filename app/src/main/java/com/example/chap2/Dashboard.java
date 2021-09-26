package com.example.chap2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    Animation topAnim, bottomAnim;

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String EMAIL_KEY = "email_key";
    public static final String PASSWORD_KEY = "password_key";

    public SharedPreferences sharedPreferences;
    public String email, password;

    ImageView img;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dashboard);

        EditText emailEdt = findViewById(R.id.username);
        EditText passwordEdt = findViewById(R.id.password);
        Button loginbtn = findViewById(R.id.signInId);

        sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        email = sharedPreferences.getString(EMAIL_KEY, null);
        password = sharedPreferences.getString(PASSWORD_KEY, null);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animate);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animate);

        img = findViewById(R.id.logo_img);
        logo = findViewById(R.id.logo_name);
        slogan = findViewById(R.id.slogan_name);

//        img.setAnimation(topAnim);
//        logo.setAnimation(bottomAnim);
//        slogan.setAnimation(bottomAnim);

        loginbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                if(TextUtils.isEmpty(emailEdt.getText().toString()) && TextUtils.isEmpty(passwordEdt.getText().toString()) ){
                    Toast.makeText(Dashboard.this, "Please Enter Email Id and Pasword", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString(EMAIL_KEY, emailEdt.getText().toString());
                    editor.putString(PASSWORD_KEY, passwordEdt.getText().toString());

                    editor.apply();

                    Intent i = new Intent(Dashboard.this, HomeActivity.class);

                    startActivity(i);
                    finish();
                }
            }
        });

        Button signUpBtn = findViewById(R.id.signUpId);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, RegisterActivity.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(img, "logo_img");
                pairs[1] = new Pair<View, String>(logo, "logo_name");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Dashboard.this, pairs);
                startActivity(intent,options.toBundle());

                //startActivity(i);
                finish();
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        if(email != null && password != null){
            Intent i = new Intent(Dashboard.this, HomeActivity.class);

            startActivity(i);
            //finish();
        }
    }


}