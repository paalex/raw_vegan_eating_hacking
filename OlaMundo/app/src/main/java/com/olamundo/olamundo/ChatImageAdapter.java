package com.olamundo.olamundo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexpavtoulov on 6/6/16.
 */
public class ChatImageAdapter extends BaseAdapter {

    private Context aContext;
    private ArrayList<ArrayList<Drawable>> chatArray = new ArrayList<ArrayList<Drawable>>();
    private ArrayList<Drawable> currentMessageArray = new ArrayList<Drawable>();


    public ChatImageAdapter(Context c) {

        aContext = c;
    }



    @Override
    public int getCount() {
        return chatArray.size();
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

        ScrollView messageScrollView;
        LinearLayout messageLinearLayout = new LinearLayout(aContext);

        if (convertView == null) {
            messageScrollView = new ScrollView(aContext);

        } else {
            messageScrollView = (ScrollView)convertView;
            messageScrollView.removeAllViews();
        }

        messageScrollView.addView(messageLinearLayout);

//        ViewGroup.LayoutParams messageLayout = new GridView.LayoutParams(aContext,);
//                messageLinearLayout.setLayoutParams();
        messageLinearLayout.setLayoutParams(new ScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        messageLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        if (position == chatArray.size()-1) {
            messageLinearLayout.setBackgroundColor(Color.GRAY);
        }

        ArrayList<Drawable> thisMessageArray = chatArray.get(position);
        for (Drawable symbol: thisMessageArray) {

            ImageView symbolImageView = new ImageView(aContext);
            symbolImageView.setLayoutParams(new LinearLayout.LayoutParams(350,350));
            symbolImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            symbolImageView.setImageDrawable(symbol);

            messageLinearLayout.addView(symbolImageView);
        }

        return messageScrollView;
    }

    public void addSymbolToMessage(Drawable message){
        currentMessageArray.add(message);

        if (chatArray.size() != 0){
            chatArray.remove(chatArray.size()-1);
        }
        ArrayList<Drawable> tempArr = (ArrayList<Drawable>) currentMessageArray.clone();
        chatArray.add(tempArr);
    }

    public void addMessageToChat(){
        currentMessageArray.clear();
        chatArray.add(currentMessageArray);
    }

    public void deleteChatHistory(){
        chatArray.clear();

    }




}
