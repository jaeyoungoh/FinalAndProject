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

    public gathering_chatting(Context context) {
        super(context);
        excute(context);
    }

    public void excute(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        inflater.inflate(R.layout.gathering_chatting, this, true);
        itemInsert();
    }

    private void itemInsert(){
//        Listviewitem3 test1,test3,test2,test4;
        ArrayList<Listviewitem4> data=null;
        ListView listView;
        listView=(ListView)findViewById(R.id.listview);
        Log.i("date",new Date(2016,8,16)+"");
        data=new ArrayList<Listviewitem4>();
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕","1",new Date(2016,8,16),"1",0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"뭐해","1",new Date(2016,8,16),"1",0));


        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"잔다","1",new Date(2016,8,16),"2",1));


        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"안녕","1",new Date(2016,8,16),"1",0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"뭐해","1",new Date(2016,8,16),"1",0));

        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"안녕안녕안녕안녕안녕안녕녕안녕안녕안녕안녕","1",new Date(2016,8,16),"2",1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"잔다","1",new Date(2016,8,16),"2",1));  data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"안녕","1",new Date(2016,8,16),"1",0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"뭐해","1",new Date(2016,8,16),"1",0));

        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"안녕","1",new Date(2016,8,16),"2",1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"잔다","1",new Date(2016,8,16),"2",1));  data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"안녕","1",new Date(2016,8,16),"1",0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"뭐해","1",new Date(2016,8,16),"1",0));

        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"안녕","1",new Date(2016,8,16),"2",1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"잔다","1",new Date(2016,8,16),"2",1));  data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"안녕","1",new Date(2016,8,16),"1",0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"뭐해","1",new Date(2016,8,16),"1",0));

        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"안녕","1",new Date(2016,8,16),"2",1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"잔다","1",new Date(2016,8,16),"2",1));  data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"안녕","1",new Date(2016,8,16),"1",0));
        data.add(new Listviewitem4(R.drawable.ic_account_circle_black_48dp,"뭐해","1",new Date(2016,8,16),"1",0));

        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"안녕","1",new Date(2016,8,16),"2",1));
        data.add(new Listviewitem4(R.drawable.ic_search_black_48dp,"잔다","1",new Date(2016,8,16),"2",1));

//int icon, String name, String num, Date date,String id
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ListviewAdapter4 adapter =new ListviewAdapter4(getContext(),data);
        listView.setAdapter(adapter);

    }
}



