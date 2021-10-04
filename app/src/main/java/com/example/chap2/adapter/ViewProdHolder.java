package com.example.chap2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chap2.R;
import com.example.chap2.activity.ProductActivity;
import com.example.chap2.activity.SellActivity;

public class ViewProdHolder extends RecyclerView.ViewHolder{
    TextView title;
    ImageView gridIcon;
    Context context;


    public ViewProdHolder(@NonNull View itemView, Context ctx) {
        super(itemView);
        title = itemView.findViewById(R.id.textCardId);
        gridIcon = itemView.findViewById(R.id.cardImgId);
        context = ctx;

            /*itemView.setOnClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    //Toast.makeText(HomeActivity.this, "Image Position: " + position, Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(HomeActivity.this, ProductActivity.class);

                    i.putExtra("id", position);
                    context.startActivity(i);

                }
            });*/

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SellActivity.class);

                i.putExtra("id", 1); //use key
                context.startActivity(i);
            }
        });
    }
}
