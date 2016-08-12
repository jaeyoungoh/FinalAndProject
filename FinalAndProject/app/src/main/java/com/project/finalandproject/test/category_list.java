package com.project.finalandproject.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.project.finalandproject.R;

/**
 * Created by Administrator on 2016-08-10.
 */
public class category_list extends Activity{
    int count=0;
    String categorytxt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_menu_layout);
        LinearLayout container=(LinearLayout) findViewById(R.id.container);
        TextView title=(TextView) findViewById(R.id.title);
        TextView next=(TextView) findViewById(R.id.next);
        next.setText("건너뛰기");
        title.setText("카테고리선택");
        ImageButton back=(ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        LayoutInflater inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.category, container,true);
        final GridLayout category=(GridLayout) findViewById(R.id.category);
        for(int i=0;i<category.getChildCount();i++){
            category.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        select(view);
                }
            });
        }
    }

    private void select(View view){

            if(categorytxt.indexOf((((Button) view).getText().toString() + ","))!=-1) {
                count--;
                categorytxt = categorytxt.replace((((Button) view).getText().toString() + ","), "");
                view.setSelected(false);
            }else{
            if(count<3) {
                count++;
                categorytxt += ((Button) view).getText().toString() + ",";
                view.setSelected(true);
            }else{
                Toast.makeText(getApplicationContext(),"카테고리는 3개만 선택해 주세요.",Toast.LENGTH_SHORT).show();
            }
            }
        Log.i("category",categorytxt+","+count);



    }
}
