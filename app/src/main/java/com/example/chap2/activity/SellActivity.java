package com.example.chap2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.chap2.R;
import com.example.chap2.adapter.ImageProductAdapter;

public class SellActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageProductAdapter imageAdapter = new ImageProductAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.fullImgId);
        imageView.setImageResource(imageAdapter.thumbImages[position]);
    }
}