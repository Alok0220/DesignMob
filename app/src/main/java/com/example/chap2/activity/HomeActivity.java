package com.example.chap2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chap2.R;
import com.example.chap2.adapter.RecyclerAdapter;
import com.example.chap2.interfaceShared.SharedPrefInterface;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SharedPrefInterface {

    SharedPreferences sharedpreferences;
    String email;
    String password;

    RecyclerView dataList;
    List<String> titles;
    List<Integer> images11;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try{
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

                    Intent i = new Intent(HomeActivity.this, Dashboard.class);
                    startActivity(i);
                    finish();
                }
            });


        /*GridView gv = (GridView) findViewById(R.id.gviewProId);
        gv.setAdapter(new ImageAdapter(this));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(HomeActivity.this, "Image Position: " + position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(HomeActivity.this, ProductActivity.class);

                i.putExtra("id", position);
                startActivity(i);

            }
        });*/

            dataList = findViewById(R.id.recyclerId);

            titles = new ArrayList<>();
            images11 = new ArrayList<>();

            titles.add("First");
            titles.add("Second");
            titles.add("Thrid");
            titles.add("Fourth");

            images11.add(R.drawable.images2);
            images11.add(R.drawable.images3);
            images11.add(R.drawable.images5);
            images11.add(R.drawable.images7);

            adapter = new RecyclerAdapter(this, titles, images11);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);

            dataList.setLayoutManager(gridLayoutManager);
            dataList.setAdapter(adapter);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    protected void onStart(){
        super.onStart();

        try{
            email = sharedpreferences.getString(EMAIL_KEY, null);
            password = sharedpreferences.getString(PASSWORD_KEY, null);

            if(email == null && password == null){
                Intent i = new Intent(HomeActivity.this, Dashboard.class);

                startActivity(i);
                //finish();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}