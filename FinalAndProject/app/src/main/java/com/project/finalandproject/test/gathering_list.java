package com.project.finalandproject.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.project.finalandproject.R;
import com.project.finalandproject.member.category_list;

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
        Listviewitem3 test1,test3,test2,test4;
        ArrayList<Listviewitem3> data;
        ListView listView;
        listView=(ListView)findViewById(R.id.listview);
        final ImageButton gathering_insert=(ImageButton)findViewById(R.id.gathering_insert);
        gathering_insert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, gathering_insert.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, gathering_view.class);
                intent.putExtra("num",(String)adapterView.getAdapter().getItem(2));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);
                //선택한 아이템의 num 전송.


            }
        });
        data=new ArrayList<>();
        test1 =new Listviewitem3(R.drawable.samplewide1,"실전영어회화","1","1/20\n천안");
        test2 =new Listviewitem3(R.drawable.samplewide2,"<다이버후드>스킨스쿠버동호회","2","1/20\n부산");
        test3 =new Listviewitem3(R.drawable.samplewide3,"WFM전세계친구만들기","3","1/20\n전국");
        test4 =new Listviewitem3(R.drawable.samplebg,"서울 자기개발","4","1/20\n서울");
        data.add(test1);
        data.add(test2);
        data.add(test3);
        data.add(test4);
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        ListviewAdapter3 adapter =new ListviewAdapter3(getContext(),R.layout.item,data);
        listView.setAdapter(adapter);
    }
}
