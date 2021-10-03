package com.example.chap2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.chap2.R;

public class ImageProductAdapter extends BaseAdapter {

    private Context mContext;

    public ImageProductAdapter(Context c)
    {
        mContext = c;
    }

    public int getCount(){
        return thumbImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(thumbImages[position]);
        return imageView;
    }

    // Add all our images to arraylist
    public Integer[] thumbImages = {
            R.drawable.download2, R.drawable.download3,
            R.drawable.download4, R.drawable.download5,
            R.drawable.download6, R.drawable.download7,
            R.drawable.download2, R.drawable.download3,
            R.drawable.download4, R.drawable.download5,
            R.drawable.download6, R.drawable.download7
    };

}
