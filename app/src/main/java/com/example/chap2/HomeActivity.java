package com.example.chap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String EMAIL_KEY = "email_key";
    public static final String PASSWORD_KEY = "password_key";

    SharedPreferences sharedpreferences;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        email = sharedpreferences.getString(EMAIL_KEY, null);

        TextView welocomeTV = findViewById(R.id.showEmailId);
        welocomeTV.setText("Welcome \n"+ email);
        Button logoutBtn = findViewById(R.id.logoutId);

        logoutBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.clear();

                editor.apply();

                Intent i = new Intent(HomeActivity.this, Dashboard.class);
                startActivity(i);
                finish();
            }
        });

    }
}