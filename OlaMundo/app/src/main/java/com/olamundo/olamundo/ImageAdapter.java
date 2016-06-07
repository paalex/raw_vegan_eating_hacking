package com.olamundo.olamundo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by alexpavtoulov on 6/6/16.
 */
public class ImageAdapter extends BaseAdapter {

    private Context aContext;

    public ImageAdapter(Context c) {

        aContext = c;
    }

    @Override
    public int getCount() {
        return imageNameArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imgView;
        if (convertView == null) {
            imgView = new ImageView(aContext);
            imgView.setLayoutParams(new GridView.LayoutParams(200,200));
            imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imgView = (ImageView) convertView;
        }
        imgView.setImageResource(imageNameArray[position]);
        return imgView;
    }

    Integer[] imageNameArray = {
            R.drawable.allow
            , R.drawable.afraid , R.drawable.angry, R.drawable.bad, R.drawable.banana, R.drawable.best, R.drawable.bicycle, R.drawable.busy
            , R.drawable.but, R.drawable.call, R.drawable.car, R.drawable.cat, R.drawable.coffee, R.drawable.coffee, R.drawable.corn

    };



}
