package com.project.finalandproject.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.project.finalandproject.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-03.
 */
public class ListviewActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testholdtitle);
        LinearLayout container = (LinearLayout) findViewById(R.id.containerInflater);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.test_top, container,true);

        ListView listView=(ListView)findViewById(R.id.listview);
        ArrayList<Listviewitem> data=new ArrayList<>();
        Listviewitem test1 =new Listviewitem(R.drawable.samplewide1,"test1");
        Listviewitem test2 =new Listviewitem(R.drawable.samplewide2,"test2");
        Listviewitem test3 =new Listviewitem(R.drawable.samplewide3,"test3");
        Listviewitem test4 =new Listviewitem(R.drawable.samplebg,"test4");
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
        data.add(test4);
        ListviewAdapter adapter=new ListviewAdapter(this,R.layout.item,data);
        listView.setAdapter(adapter);
    }
}
