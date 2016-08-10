package com.project.finalandproject.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.project.finalandproject.R;

import java.util.ArrayList;

/**
 * Created by 김희윤 on 2016-08-10.
 */
public class gathering_list extends LinearLayout {

    //gathering_list

    Context context;
    public gathering_list(Context context){
        super(context);
        excute(context);
    }

    public void excute(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.gathering_list_view, this, true);
        itemInsert();
    }

    private void itemInsert(){
        Listviewitem test1,test3,test2,test4;
        ArrayList<Listviewitem> data;
        ListView listView;
        listView=(ListView)findViewById(R.id.listview);
        data=new ArrayList<>();
        test1 =new Listviewitem(R.drawable.samplewide1,"test1");
        test2 =new Listviewitem(R.drawable.samplewide2,"test2");
        test3 =new Listviewitem(R.drawable.samplewide3,"test3");
        test4 =new Listviewitem(R.drawable.samplebg,"test4");
        data.add(test1);
        data.add(test2);
        data.add(test3);
        data.add(test4);
        data.add(test1);
        data.add(test2);
        data.add(test3);
        data.add(test4);
        data.add(test1);
        data.add(test2);
        data.add(test3);
        data.add(test4);
        data.add(test1);
        data.add(test2);
        data.add(test3);
        ListviewAdapter adapter =new ListviewAdapter(getContext(),R.layout.item,data);
        listView.setAdapter(adapter);
    }
}
