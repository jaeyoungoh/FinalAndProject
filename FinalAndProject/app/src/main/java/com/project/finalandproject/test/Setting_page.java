package com.project.finalandproject.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.project.finalandproject.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-10.
 */
public class Setting_page extends LinearLayout{

    Context context;
    public Setting_page(Context context){
        super(context);
        excute(context);
    }

    public void excute(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.setting_page, this, true);
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
        ListviewAdapter adapter =new ListviewAdapter(getContext(),R.layout.item1,data);
        listView.setAdapter(adapter);
    }
}
