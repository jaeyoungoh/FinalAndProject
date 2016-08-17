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
public class ListviewAdapter3 extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Listviewitem3> data;
    private int layout;
    public ListviewAdapter3(Context context, int layout, ArrayList<Listviewitem3> data){
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount(){
        return data.size();
    }
    @Override
    public Listviewitem3 getItem(int position){return data.get(position);}
    @Override
    public long getItemId(int position){return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView=inflater.inflate(layout,parent,false);
        }
        Listviewitem3 listviewitem=data.get(position);
        ImageView icon=(ImageView)convertView.findViewById(R.id.imageview);
        icon.setImageResource(listviewitem.getIcon());
        TextView name=(TextView)convertView.findViewById(R.id.textview);
        name.setText(listviewitem.getName());
        TextView num=(TextView)convertView.findViewById(R.id.GATHERING_NUM);
        num.setText(listviewitem.getNum());
        TextView information=(TextView)convertView.findViewById(R.id.GATHERING_INFORMATION);
        information.setText(listviewitem.getInformation());
        return convertView;
    }
    public void setColor(){

    }


}
