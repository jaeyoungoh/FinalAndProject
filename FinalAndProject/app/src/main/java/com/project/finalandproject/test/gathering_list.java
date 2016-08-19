package com.project.finalandproject.test;

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
        Log.i("msg","리스트뽑기");
    }

    private void itemInsert(){
//        Listviewitem3 test1,test3,test2,test4;
        Listviewitem3 test;
        ArrayList<Listviewitem3> data;
        ListView listView;
        listView=(ListView)findViewById(R.id.listview1);
        final ImageButton gathering_insert=(ImageButton)findViewById(R.id.btn_gathering_insert);
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
                Intent intent = new Intent(context, Test_Menu_Activity2.class);
                Log.i("num",((Listviewitem3)adapterView.getAdapter().getItem(i)).getNum());
                intent.putExtra("num",(String)((Listviewitem3)adapterView.getAdapter().getItem(i)).getNum());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                //선택한 아이템의 num 전송.


            }
        });
        JSONObject obj  = new JSONObject();
        JSONArray jArr = (JSONArray) GatheringConn.getJSONDatas("list", null);
        data=new ArrayList<>();
//        Log.i("result","jArr의 내용 : "+jArr.toString());
//        Log.i("result","jArr의 싸이즈 : "+jArr.size());
        for(int i=0;i<jArr.size();i++){
            obj = (JSONObject)jArr.get(i);
            test =new Listviewitem3(R.drawable.samplewide1,obj.get("Gathering_title").toString(),obj.get("Gathering_num").toString(),"1/"+obj.get("Gathering_max_cnt").toString()+"\n"+obj.get("Gathering_location").toString());
            data.add(test);
        }
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Log.i("msg","여기까지옴1");
        ListviewAdapter3 adapter =new ListviewAdapter3(context,R.layout.item,data);
        Log.i("msg","여기까지옴2");
        listView.setAdapter(adapter);
        Log.i("msg","여기까지옴3");
    }
}
