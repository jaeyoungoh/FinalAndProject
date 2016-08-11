package com.project.finalandproject.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.finalandproject.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-03.
 */
public class ListviewAdapter2 extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<String> data;
    private int layout;
    public ListviewAdapter2(Context context, int layout, ArrayList<String> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount(){
        return data.size();
    }
    @Override
    public String getItem(int position){return data.get(position);}
    @Override
    public long getItemId(int position){return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        TextView name=(TextView)convertView.findViewById(R.id.textview);
        name.setText(data.get(position));
        return convertView;
    }
    public void setColor(){

    }


}
