package com.project.finalandproject.test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

        String num = intent.getStringExtra("num");




        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        inflater.inflate(R.layout.gathering_view, this, true);
        GATHERING_TITLE = (TextView) findViewById(R.id.GATHERING_TITLE);
        GATHERING_CONTENT = (TextView) findViewById(R.id.GATHERING_CONTENT);
        GATHERING_HASHTAG = (TextView) findViewById(R.id.GATHERING_HASHTAG);
        GATHERING_MAX_CNT = (TextView) findViewById(R.id.GATHERING_MAX_CNT);
        GATHERING_LOCATION = (TextView) findViewById(R.id.GATHERING_LOCATION);

        obj = (JSONObject) jArr.get(Integer.parseInt(num));
        Log.i("title",obj.get("Gathering_title").toString());
        GATHERING_TITLE.setText(""+obj.get("Gathering_title").toString());
    }


}




