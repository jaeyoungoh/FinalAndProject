package com.project.finalandproject.gathering;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.finalandproject.R;
import com.project.finalandproject.conn.GatheringConn;
import com.project.finalandproject.dto.GatheringDTO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Administrator on 2016-08-10.
 */
public class gathering_view2 extends LinearLayout {
    AlertDialog.Builder ad;
    String msg[];
    //gathering_list

    Context context;
    Intent intent;
    GatheringDTO gatheringDTO = new GatheringDTO();
    JSONObject obj = new JSONObject();
    JSONArray jArr = (JSONArray) GatheringConn.getJSONDatas("list", null);
    TextView GATHERING_TITLE, GATHERING_CONTENT, GATHERING_HASHTAG, GATHERING_MAX_CNT, GATHERING_LOCATION;

    public gathering_view2(Context context,Intent intent) {
        super(context);
        excute(context,intent);
    }

    public void excute(Context context,Intent intent) {
        this.context = context;
        this.intent=intent;

        String num = intent.getStringExtra("num"); //Intent로 num을 받아옴.


        for(int i=0; i<jArr.size(); i++){
            obj = (JSONObject)jArr.get(i);
            if(num.equals(obj.get("Gathering_num").toString())) break;
        }


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        inflater.inflate(R.layout.gathering_view, this, true);
        GATHERING_TITLE = (TextView) findViewById(R.id.GATHERING_TITLE);
        GATHERING_CONTENT = (TextView) findViewById(R.id.GATHERING_CONTENT);
        GATHERING_HASHTAG = (TextView) findViewById(R.id.GATHERING_HASHTAG);
        GATHERING_MAX_CNT = (TextView) findViewById(R.id.GATHERING_MAX_CNT);
        GATHERING_LOCATION = (TextView) findViewById(R.id.GATHERING_LOCATION);

        GATHERING_TITLE.setText(""+obj.get("Gathering_title").toString());
        GATHERING_CONTENT.setText(""+obj.get("Gathering_content").toString());
        try {
            GATHERING_HASHTAG.setText("" + obj.get("Gathering_hashtag").toString());
        } catch(Exception e){
            GATHERING_HASHTAG.setText("없음.");
        }

        GATHERING_MAX_CNT.setText(""+obj.get("Gathering_max_cnt").toString());
        GATHERING_LOCATION.setText(""+obj.get("Gathering_location").toString());
    }


}




