package com.olamundo.olamundo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpavtoulov on 6/6/16.
 */
public class ChatImageAdapter extends BaseAdapter {

    private Context aContext;
    private List<Drawable> imageNameArray = new ArrayList<Drawable>();



    public ChatImageAdapter(Context c) {

        aContext = c;
    }



    @Override
    public int getCount() {
//        Integer count;
//        if (imageNameArray == null){
//            count = 0;
//        } else {
//            count = imageNameArray.size();
//        }

        return imageNameArray.size();
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
            imgView.setLayoutParams(new GridView.LayoutParams(350,350));
            imgView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imgView = (ImageView) convertView;
        }
        imgView.setImageDrawable(imageNameArray.get(position));
        return imgView;
    }

    public void appendMessage(Drawable message){
        if (imageNameArray == null) {

        }
        imageNameArray.add(message);
    }

    public void deleteChatHistory(){
        imageNameArray.clear();

    }




}
