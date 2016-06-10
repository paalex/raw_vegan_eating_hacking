package com.olamundo.olamundo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
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
    private ArrayList<ArrayList<Drawable>> chatArray = new ArrayList<>();


    public ArrayList<ArrayList<Drawable>> getChatArray() {
        return chatArray;
    }

    public void setChatArray(ArrayList<ArrayList<Drawable>> chatArray) {
        this.chatArray = chatArray;
    }


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

        HorizontalScrollView messageScrollView;
        LinearLayout messageLinearLayout = new LinearLayout(aContext);

        if (convertView == null) {
            messageScrollView = new HorizontalScrollView(aContext);

        } else {
            messageScrollView = (HorizontalScrollView)convertView;
            messageScrollView.removeAllViews();
        }

        messageScrollView.addView(messageLinearLayout);
        messageScrollView.setLayoutParams(new ListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        messageScrollView.setHorizontalFadingEdgeEnabled(true);
        messageScrollView.setFadingEdgeLength(150);

        messageLinearLayout.setLayoutParams(new HorizontalScrollView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        messageLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        if (position == chatArray.size()-1) {
            messageLinearLayout.setBackgroundColor(Color.LTGRAY);

        }

        ArrayList<Drawable> thisMessageArray = chatArray.get(position);
        for (Drawable symbol: thisMessageArray) {

            ImageView symbolImageView = new ImageView(aContext);
            symbolImageView.setLayoutParams(new LinearLayout.LayoutParams(250,250));
            symbolImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

            symbolImageView.setImageDrawable(symbol);

            messageLinearLayout.addView(symbolImageView);
        }

        return messageScrollView;
    }

    public void addSymbolToMessage(Drawable img){

        ArrayList<Drawable> currentMessageArray;

        if (chatArray.size() != 0) {
            currentMessageArray = chatArray.get(chatArray.size() - 1);
            currentMessageArray.add(img);
            chatArray.remove(chatArray.size() - 1);

        } else {
            currentMessageArray = new ArrayList<>();
            currentMessageArray.add(img);

        }

        chatArray.add(currentMessageArray);


    }

    public void addMessageToChat(){
        if(!chatArray.isEmpty() && !chatArray.get(chatArray.size()-1).isEmpty()) {
            chatArray.add(new ArrayList<Drawable>());
        }


    }

    public void deleteChatHistory(){
        chatArray.clear();


    }




}
