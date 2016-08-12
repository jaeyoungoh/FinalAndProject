package com.project.finalandproject.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;
import com.project.finalandproject.dto.GatheringDTO;
import com.project.finalandproject.member.category_list;

/**
 * Created by Administrator on 2016-08-10.
 */
public class gathering_insert extends Activity{
    AlertDialog.Builder ad;
    String msg[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu_layout);
        LinearLayout container=(LinearLayout) findViewById(R.id.container);
        TextView title=(TextView) findViewById(R.id.title);
        TextView next=(TextView) findViewById(R.id.next);
        next.setText("");
        title.setText("그룹생성");
        ImageButton back=(ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ad=new AlertDialog.Builder(this);
        ad.setTitle("주 활동지역");
        msg=getResources().getStringArray(R.array.area);
        ad.setItems(msg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int index) {
                ((TextView)findViewById(R.id.GATHERING_LOCATION)).setText(msg[index]);
            }
        });


        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.gathering_insert, container,true);
        ((TextView)findViewById(R.id.GATHERING_LOCATION_ICON)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.show();
            }
        });
        ((Button)findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GatheringDTO dto=new GatheringDTO();
                dto.setGathering_content(((EditText)findViewById(R.id.GATHERING_CONTENT)).getText().toString());
                dto.setGathering_location(((TextView)findViewById(R.id.GATHERING_LOCATION)).getText().toString());
                dto.setGathering_title(((EditText)findViewById(R.id.GATHERING_TITLE)).getText().toString());
                dto.setGathering_hashtag(((EditText)findViewById(R.id.GATHERING_HASHTAG)).getText().toString());
                dto.setGathering_max_cnt(Integer.parseInt(((EditText)findViewById(R.id.GATHERING_MAX_CNT)).getText().toString()));
                Intent intent=new Intent(getApplication(),category_list.class);
                intent.putExtra("dto",dto);
                intent.putExtra("type","gjoin");
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
