package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.project.finalandproject.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-08-10.
 */
public class gathering_insert extends Activity{


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

        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.gathering_insert, container,true);
        ((Button)findViewById(R.id.submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplication(),category_list.class);
                startActivity(intent);
            }
        });
    }


}
