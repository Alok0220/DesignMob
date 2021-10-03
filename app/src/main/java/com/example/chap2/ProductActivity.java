package com.example.chap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class ProductActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "shared_prefs";
    public static final String EMAIL_KEY = "email_key";
    public static final String PASSWORD_KEY = "password_key";

    SharedPreferences sharedpreferences;
    String email;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);

        email = sharedpreferences.getString(EMAIL_KEY, null);

        //TextView welocomeTV = findViewById(R.id.showEmailId);
        //welocomeTV.setText("Welcome \n"+ email);
        Button logoutBtn = findViewById(R.id.logoutId);

        logoutBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.clear();

                editor.apply();

                Intent i = new Intent(ProductActivity.this, Dashboard.class);
                startActivity(i);
                finish();
            }
        });


        /*GridView gv = (GridView) findViewById(R.id.gviewId);
        gv.setAdapter(new ImageProductAdapter(this));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(HomeActivity.this, "Image Position: " + position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ProductActivity.this, SellActivity.class);

                i.putExtra("id", position);
                startActivity(i);

            }
        });*/

    }

    @Override
    protected void onStart(){
        super.onStart();

        email = sharedpreferences.getString(EMAIL_KEY, null);
        password = sharedpreferences.getString(PASSWORD_KEY, null);

        if(email == null && password == null){
            Intent i = new Intent(ProductActivity.this, Dashboard.class);

            startActivity(i);
            //finish();
        }
    }
}