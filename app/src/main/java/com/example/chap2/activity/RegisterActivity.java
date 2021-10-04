package com.example.chap2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chap2.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regidter);

        try{
            Button backBtn = findViewById(R.id.backBtnId);

            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(RegisterActivity.this, Dashboard.class);
                    startActivity(i);
                    finish();
                }
            });
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }


}