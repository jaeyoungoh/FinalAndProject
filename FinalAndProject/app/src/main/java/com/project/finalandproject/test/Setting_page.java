package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.project.finalandproject.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-10.
 */
public class Setting_page extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu_layout);
        setContentView(R.layout.top_menu_layout);
        LinearLayout container=(LinearLayout) findViewById(R.id.container);
        TextView title=(TextView) findViewById(R.id.title);
        TextView next=(TextView) findViewById(R.id.next);
        next.setText("");
        title.setText("설정");
        ImageButton back=(ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.setting_page, container,true);
        itemInsert();
    }

    private void itemInsert(){
        Listviewitem logout,version,notice,out;
        ArrayList<Listviewitem> data;
        ListView listView;
        listView=(ListView)findViewById(R.id.listview);
        data=new ArrayList<>();
        logout =new Listviewitem(R.drawable.ic_account_circle_black_48dp,"로그아웃");
        version =new Listviewitem(R.drawable.ic_action_name,"버전정보");
        notice =new Listviewitem(R.drawable.ic_man,"공지사항");
        out =new Listviewitem(R.drawable.ic_menu_gallery,"회원탈퇴");
        data.add(logout);
        data.add(version);
        data.add(notice);
        data.add(out);
        ListviewAdapter adapter =new ListviewAdapter(getApplication(),R.layout.item1,data);
        listView.setAdapter(adapter);
    }
}
