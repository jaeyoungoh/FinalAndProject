package com.project.finalandproject.test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.project.finalandproject.R;
import com.project.finalandproject.conn.GatheringConn;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2016-08-10.
 */
public class gathering_chatting extends LinearLayout {
    //gathering_list

    Context context;
    ArrayList<Listviewitem4> data;
    ListView listView;
    ListviewAdapter4 adapter;

    public gathering_chatting(Context context) {
        super(context);
        excute(context);
    }

    public void excute(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        inflater.inflate(R.layout.gathering_chatting, this, true);
        listView = (ListView) findViewById(R.id.listview);
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        data= new ArrayList<Listviewitem4>();
        itemInsert();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        itemInsert2();
                        Log.i("msg",i+"");
                    }/*
                adapter = new ListviewAdapter4(getContext(), data);
                listView.setAdapter(adapter);*/
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void itemInsert2() {
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "안녕22222" , "진혁이", new Date(System.currentTimeMillis()), "2", 1));
        adapter.notifyDataSetChanged();


    }


    private void itemInsert() {

        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp, "안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕", "1", new Date(2016, 8, 16), "1", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "뭐해", "1", new Date(2016, 8, 16), "아이디", 1));
/*

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context,"선택"+data.get(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
//int icon, String name, String num, Date date,String id

*/

        //listView.requestFocusFromTouch();
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "잔다1", "1", new Date(2016, 8, 16), "2", 0));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp, "분기점2", "1", new Date(2016, 8, 16), "2", 0));
        adapter = new ListviewAdapter4(context.getApplicationContext(), data);
        listView.setAdapter(adapter);
        listView.setSelection(data.size()-1);
        listView.setDivider(null);

    }
}



