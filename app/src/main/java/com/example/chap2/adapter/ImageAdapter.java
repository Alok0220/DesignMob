package com.example.chap2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.chap2.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c)
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

        ImageView imageView = null;
        try{
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setImageResource(thumbImages[position]);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return imageView;
    }

    // Add all our images to arraylist
    public Integer[] thumbImages = {
            R.drawable.download1, R.drawable.images2,
            R.drawable.images3, R.drawable.richo4,
            R.drawable.images5, R.drawable.images7,
            R.drawable.shutterstock6,
            R.drawable.download1, R.drawable.images2,
            R.drawable.images3, R.drawable.richo4,
            R.drawable.images5, R.drawable.images7,
            R.drawable.shutterstock6,
            R.drawable.download1, R.drawable.images2,
            R.drawable.images3, R.drawable.richo4,
            R.drawable.images5, R.drawable.images7,
            R.drawable.shutterstock6
    };
}
